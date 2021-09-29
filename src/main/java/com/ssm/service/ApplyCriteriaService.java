package com.ssm.service;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.ApplyCriteria;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface ApplyCriteriaService {
    /**
     * 查询所有申请表信息
     * @return
     */
    List<ApplyCriteria> getApplication(Integer room);


    /**
     * 根据id查询
     * @param applyId
     * @return
     */
    ApplyCriteria getApplicationById(String applyId);

    /**
     * 根据员工id查询
     * @param empId
     * @return
     */
    List<ApplyCriteria> getAppByEmpId(Integer empId);




    /**
     * 根据申请日期查询订单
     * @param applyDate
     * @param sevenLater
     * @return
     */
    List<ApplyCriteria> getApplyByApplyDate(String applyDate,String sevenLater);

    /**
     * 分别查询7天的订单
     * @param applyDate
     * @return
     */
    List<ApplyCriteria> getDateTime(String applyDate);

}
