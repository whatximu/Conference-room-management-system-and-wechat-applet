package com.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.Application;
import com.ssm.entity.ApplyCount;
import com.ssm.entity.Room;
import com.ssm.service.impl.ApplicationServiceImpl;
import com.ssm.util.Tool;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonObject;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



@RestController
public class ApplicationController {
    @Qualifier("ApplicationService")
    @Autowired
    private ApplicationServiceImpl applicationService;


    /**
     * 查询所有的会议室
     * @return
     */


    /**
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/submit_application", method = RequestMethod.POST)
    public JSONObject changepoints(@RequestBody JSONObject request ) {
        return applicationService.submit_application(request);
    }

    /**
     * 添加订单
     *
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addApplyFrom", method = RequestMethod.GET)
    public int addApplyFrom(@RequestParam("str") String data) throws Exception {
        Application application = new Application();
        //非空判断
        if (StringUtils.isBlank(data)) {
            return 0;
        }
        data = URLDecoder.decode(data, "UTF-8");

        /****/
        //解析获取的数据
        Map<String, String> map = Tool.URLRequest(data);
        //获取开始时间
        String getStartTime = map.get("startTime");
        if (getStartTime != null && getStartTime != "") {
            application.setStartTime(getStartTime);
        }
        //获取当前日期
        String applyDate = map.get("applyDate");
        if (StringUtils.isNotBlank(applyDate)) {
            application.setApplyDate(applyDate);
        }
        //获取结束时间
        String getEndTime = map.get("endTime");
        if (getEndTime != null && getEndTime != "") {
            application.setEndTime(getEndTime);
        }

        //获取员工ID
        String empId = map.get("empId");
        if (StringUtils.isNotBlank(empId)) {
            application.setEmpId(Integer.valueOf(empId));
        }
        //获取与会人数
        String meetNum = map.get("meetNum");
        //获取会议室id
        String roomId = map.get("roomId");
        if (roomId != "" && roomId != null) {
            application.setRoomId(Integer.valueOf(roomId));
        }
        if (meetNum != "" && meetNum != null) {
            application.setMeetNum(Integer.valueOf(meetNum));
        }
        //获取申请用途
        String content = map.get("content");
        //订单号
        String applyId = "";
        //随机数
        Random random = new Random();
        String num1 = "";
        for (int i = 0; i < 7; i++) {
            num1 += random.nextInt(10);
        }
        //时间戳
        Long num2 = Calendar.getInstance().getTimeInMillis();
        //订单号
        applyId = num1 + num2;
        //封装数据
        application.setApplyId(applyId);
        application.setContent(content);
        int result = applicationService.addApplyFrom(application);
        return result;
    }

    /**
     * 删除订单
     *
     * @param applyIds
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteApply/{applyIds}", method = RequestMethod.POST)
    public int deleteApplyFrom(@PathVariable("applyIds") String applyIds) {
        int code = 0;
        int result = 0;
        if (applyIds.contains("-")) {
            List<String> delIds = new ArrayList<>();
            String[] strIds = applyIds.split("-");
            for (String applyId : strIds) {
                delIds.add(applyId);
            }
            result = applicationService.deleteApplyFrom(delIds);
            if (result > 0) {
                code = 1;
            }
        } else {
            String applyId = applyIds;
            result = applicationService.deleteApplyFrom(applyId);
            if (result > 0) {
                code = 1;
            }
        }
        return code;
    }

    /**
     * 修改订单
     *
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateApplyById", method = RequestMethod.GET)
    public int updateApply(@RequestParam("str") String data) throws Exception {
        Application application = new Application();
        //非空判断
        if (StringUtils.isBlank(data)) {
            return 0;
        }
        data = URLDecoder.decode(data, "UTF-8");

        /****/
        //解析获取的数据
        Map<String, String> map = Tool.URLRequest(data);
        //获取当前日期
        String applyDate = map.get("applyDate");
        if (StringUtils.isNotBlank(applyDate)) {
            application.setApplyDate(applyDate);
        }
        //获取开始时间
        String getStartTime = map.get("startTime");
        if (StringUtils.isNotBlank(getStartTime)) {
            application.setStartTime(getStartTime);
        }
        //获取结束时间
        String getEndTime = map.get("endTime");
        if (StringUtils.isNotBlank(getEndTime)) {
            application.setEndTime(getEndTime);
        }
        //获取员工ID
        String empId = map.get("empId");
        if (empId != "" && empId != null) {
            application.setEmpId(Integer.valueOf(empId));
        }
        //获取与会人数
        String meetNum = map.get("meetNum");
        //获取会议室id
        String roomId = map.get("roomId");
        if (roomId != "" && roomId != null) {
            application.setRoomId(Integer.valueOf(roomId));
        }
        if (meetNum != "" && meetNum != null) {
            application.setMeetNum(Integer.valueOf(meetNum));
        }
        //获取申请用途
        String content = map.get("content");

        //订单号
        String applyId = map.get("orderId");
        //封装数据
        application.setApplyId(applyId);
        application.setContent(content);
        int result = applicationService.updateApplyById(application);
        return result;
    }

    /**
     * 获取记录数
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getApplyCount")
    public ApplyCount getApplyCount() {
        return applicationService.getStateNum();
    }

    /**
     * 退订
     *
     * @param applyIds
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/returnApply/{applyIds}", method = RequestMethod.POST)
    public int returnApplyForm(@PathVariable("applyIds") String applyIds) {
        int result = 0;
        String applyId = applyIds;
        result = applicationService.returnApplyForm(applyId);
        return result;
    }
}
