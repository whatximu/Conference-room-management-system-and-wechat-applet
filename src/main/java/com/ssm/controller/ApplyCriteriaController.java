package com.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.ApplyCriteria;
import com.ssm.service.impl.ApplyCriteriaServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@Controller
public class ApplyCriteriaController {
    @Autowired
    private ApplyCriteriaServiceImpl applyCriteriaService;

    /**
     * 查询所有申请表
     *
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("/getApplication")
    public PageInfo getApplication(@RequestParam(value = "pn", defaultValue = "1") Integer pn,@RequestParam(value = "room",defaultValue = "0") Integer room) {
        //分页查询，传入页码和每页数据的个数
        PageHelper.startPage(pn, 8);
        List<ApplyCriteria> applys = applyCriteriaService.getApplication(room);
        //使用pageinfo包装查询后的结果,连续显示的页数
        PageInfo pageInfo = new PageInfo(applys, 5);
        return pageInfo;
    }

    /**
     * 根据id查询
     *
     * @param applyId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getApply/{id}", method = RequestMethod.GET)
    public ApplyCriteria getApplyById(@PathVariable("id") String applyId) {
        return applyCriteriaService.getApplicationById(applyId);
    }

    /**
     * 根据员工id查询
     *
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAppByEmpId")
    public PageInfo getAppByEmpId(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam("empid") Integer empId) {
        //分页查询，传入页码和每页数据的个数
        PageHelper.startPage(pn, 5);
        List<ApplyCriteria> applys = applyCriteriaService.getAppByEmpId(empId);
        //使用pageinfo包装查询后的结果,连续显示的页数
        PageInfo pageInfo = new PageInfo(applys, 5);
        return pageInfo;
    }


























    /**
     * 根据当前申请日期查询订单
     *
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("/getApplyFormByDate")
    public PageInfo getApplyByApplyDate(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String applyDate = dateFormat.format(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 6);

        Date time = calendar.getTime();
        String dateSevenLater = dateFormat.format(time);
        List<ApplyCriteria> applys = applyCriteriaService.getApplyByApplyDate(applyDate, dateSevenLater);
        PageHelper.startPage(pn, 5);
        PageInfo pageInfo = new PageInfo(applys, 5);
        return pageInfo;
    }

    /**
     * 甘特图显示
     *
     * @return
     * @throws ParseException
     */
    @ResponseBody
    @RequestMapping(value = "/getOrderByDate", produces = "text/plain;charset=utf-8")
    public String getApplyByDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss");
        String applyDate = dateFormat.format(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 6);

        Date time = calendar.getTime();
        String dateSevenLater = dateFormat.format(time);
        List<ApplyCriteria> applys = applyCriteriaService.getApplyByApplyDate(applyDate, dateSevenLater);
        String startTime = "";
        String endTime = "";
        Set<Integer> set = new HashSet<>();
        for (ApplyCriteria applyCriteria : applys) {
            set.add(applyCriteria.getRoomId());
            if (StringUtils.isNotBlank(applyCriteria.getStartTime())){
                startTime = applyCriteria.getApplyDate() + " " + applyCriteria.getStartTime();
                endTime = applyCriteria.getApplyDate() + " " + applyCriteria.getEndTime();
                Date parseStart = format.parse(startTime);
                Date parseEnd = format.parse(endTime);
                applyCriteria.setStartTime(String.valueOf(parseStart.getTime()));
                applyCriteria.setEndTime(String.valueOf(parseEnd.getTime()));
            }
        }
        JSONArray jsonArray = new JSONArray();
        int index = 0;
        for (Integer roomId : set) {
            String roomName = "";
            JSONArray array = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i < applys.size(); i++) {
                ApplyCriteria poll = applys.get(i);
                if (roomId == poll.getRoomId()) {
                    array.add(poll);
                    roomName = poll.getRoomName();
                }
            }
            jsonObject.put("array", array);
            jsonObject.put("roomName",roomName);
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString(jsonArray, SerializerFeature.DisableCircularReferenceDetect);
    }
}
