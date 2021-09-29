package com.ssm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.ApplicationDao;
import com.ssm.dao.RoomDao;
import com.ssm.dao.UserDao;
import com.ssm.entity.*;
import com.ssm.service.ApplicationService;
import com.ssm.util.Tool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.json.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
@Service(value = "ApplicationService")
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationDao applicationDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoomDao roomDao;

    @Override
    public int deleteApplyFrom(String applyId) {
        return applicationDao.deleteApplyFrom(applyId);
    }

    @Override
    public JSONObject submit_application(JSONObject request) {
        JSONObject result5 = new JSONObject();
        try {

            String name=request.get("room_name").toString();
            String a=applicationDao.getroomid(name);
            request.put("roomid",a);
            applicationDao.submit_application(request);
            result5.put("data",0);
        } catch (Exception e) {
            result5.put("code", "500");
            result5.put("msg", "查询异常！");
        }
        return result5;
    }


    /**
     * 退订
     *
     * @param applyId
     * @return
     */
    @Override
    public int returnApplyForm(String applyId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //该订单已无效
        Application applyById = applicationDao.getApplyById(applyId);
        if (applyById.getState() != 0) {
            return -1;
        }
        String format = dateFormat.format(new Date());
        try {
            Date getDate = dateFormat.parse(applyById.getApplyDate());
            Date parseDate = dateFormat.parse(format);
            if (getDate.getTime() < parseDate.getTime()) {
                return -2;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return applicationDao.returnApplyForm(applyId);
    }

    /**
     * 添加订单
     *
     * @param application
     * @return
     */
    @Override
    public int addApplyFrom(Application application) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        int result = 0;
        if (StringUtils.isBlank(application.getApplyDate())) {
            return result;
        }
        if (StringUtils.isBlank(application.getStartTime())) {
            //预定时间为空
            return result;
        }
        if (StringUtils.isBlank(application.getEndTime())) {
            return result;
        }
        if (application.getEmpId() == null || application.getMeetNum() == null) {
            return result;
        }
        if (application.getContent() == null || application.getContent() == "") {
            return result;
        }
        if (application.getRoomId() == null) {
            return result;
        }


        //日期判断，如果预定日期小于当前日期，不能预定
        Date applyDate = df.parse(application.getApplyDate());
        long currentTime = Tool.getTime(new Date());
        if (applyDate.getTime() < currentTime) {
            return -2;
        }
        String startTime = application.getApplyDate() +" "+ application.getStartTime();
        String endTime = application.getApplyDate()+" "+application.getEndTime();
        Date startDate = dateFormat.parse(startTime);
        Date endDate = dateFormat.parse(endTime);
        List<Application> applys = applicationDao.getApplyByRoomId(application.getRoomId());
        for (Application apply : applys) {
            String getST = apply.getApplyDate() + " " + apply.getStartTime();
            String getEN = apply.getApplyDate() + " " + apply.getEndTime();
            Date getStart = dateFormat.parse(getST);
            Date getEnd = dateFormat.parse(getEN);
            if ((startDate.getTime()<=getStart.getTime())&&(endDate.getTime()>=getStart.getTime())){
                return -4;
            }else if ((startDate.getTime()>=getStart.getTime())&&(startDate.getTime()<=getEnd.getTime())){
                return -4;
            }
        }

        //查询用户
        User userByEmpId = userDao.getUserByEmpId(application.getEmpId());
        //获取用户权限
        int roleId = userByEmpId.getRoleId();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        if (!list.contains(roleId)) {
            Room roomById = roomDao.getRoomById(application.getRoomId());
            if (roomById.getRoomName().contains("大会议室")) {
                //除了管理员和领导，没有人有权限预定大会议室
                return -3;
            }
        }
        result = applicationDao.addApplyFrom(application);
        return result;
    }

    /**
     * 批量删除订单
     *
     * @param applyIds
     * @return
     */
    @Override
    public int deleteApplyFrom(List<String> applyIds) {
        int result = 0;
        if (applyIds.size() <= 0) {
            return -1;
        }
        for (String applyId : applyIds) {
            result = applicationDao.deleteApplyFrom(applyId);
        }
        return result;
    }

    /**
     * 修改订单
     *
     * @param application
     * @return
     */
    @Override
    public int updateApplyById(Application application) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        int result = 0;
        if (StringUtils.isBlank(application.getApplyDate())) {
            return result;
        }
        if (application.getStartTime() == null || application.getEndTime() == null) {
            //预定时间为空
            return result;
        }
        if (application.getContent() == null || application.getContent() == "") {
            return result;
        }
        if (application.getRoomId() == null) {
            return result;
        }
        try {
            Date applyDate = df.parse(application.getApplyDate());
            long currentTime = Tool.getTime(new Date());
            if (applyDate.getTime() < currentTime) {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //该订单已无效
        Application applyById = applicationDao.getApplyById(application.getApplyId());
        if (applyById.getState() != 0) {
            return -3;
        }
        //查询用户
        User userByEmpId = userDao.getUserByEmpId(application.getEmpId());
        //获取用户权限
        int roleId = userByEmpId.getRoleId();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        if (!list.contains(roleId)) {
            Room roomById = roomDao.getRoomById(application.getRoomId());
            if (roomById.getRoomName().contains("大会议室")) {
                //除了管理员和领导，没有人有权限预定大会议室
                return -2;
            }
        }
        result = applicationDao.updateApplyById(application);
        return result;
    }

    @Override
    public ApplyCount getStateNum() {
        ApplyCount applyCount = new ApplyCount();
        int all = applicationDao.selectStateAll();
        int zero = applicationDao.selectStateZero();
        int one = applicationDao.selectStateOne();
        int two = applicationDao.selectStateTwo();
        int three = all - zero - one - two;
        applyCount.setAll(all);
        applyCount.setZero(zero);
        applyCount.setOne(one);
        applyCount.setTwo(two);
        applyCount.setThree(three);
        return applyCount;
    }

}
