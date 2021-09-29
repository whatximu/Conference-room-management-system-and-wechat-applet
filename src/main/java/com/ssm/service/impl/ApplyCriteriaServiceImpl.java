package com.ssm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.ApplicationDao;
import com.ssm.dao.ApplyCriteriaDao;
import com.ssm.dao.RoomDao;
import com.ssm.entity.Application;
import com.ssm.entity.ApplyCriteria;
import com.ssm.entity.Room;
import com.ssm.service.ApplyCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class ApplyCriteriaServiceImpl implements ApplyCriteriaService{
    @Autowired
    private ApplyCriteriaDao applyCriteriaDao;
    @Autowired
    private RoomDao roomDao;
    @Override
    public List<ApplyCriteria> getApplication(Integer room) {
        JSONObject a=new JSONObject();
        a.put("room",room);
        if (room==0) {
            return applyCriteriaDao.getApplication();
        }else{
            return applyCriteriaDao.getApplication21(a);
        }
    }

    @Override
    public ApplyCriteria getApplicationById(String applyId) {
        return applyCriteriaDao.getApplicationById(applyId);
    }

    @Override
    public List<ApplyCriteria> getAppByEmpId(Integer empId) {
        return applyCriteriaDao.getAppByEmpId(empId);
    }


    /**
     * 根据申请日期查询订单
     * @param applyDate
     * @param sevenLater
     * @return
     */
    @Override
    public List<ApplyCriteria> getApplyByApplyDate(String applyDate,String sevenLater) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = "00:00";
        String date = dateFormat.format(new Date());
        applyCriteriaDao.deleteBlankRoom();
        List<Room> rooms = roomDao.getAllRoom();
        for (Room room:rooms) {
            Application application = new Application();
            application.setRoomId(room.getId());
            application.setStartTime(time);
            application.setEndTime(time);
            application.setApplyDate(date);
            application.setState(2);
            int i = applyCriteriaDao.addBlankRoom(application);
        }
        return applyCriteriaDao.getApplyByApplyDate(applyDate,sevenLater);
    }

    @Override
    public List<ApplyCriteria> getDateTime(String applyDate) {
        return applyCriteriaDao.getDateTime(applyDate);
    }

}
