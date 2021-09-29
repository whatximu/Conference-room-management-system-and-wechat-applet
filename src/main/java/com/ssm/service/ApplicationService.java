package com.ssm.service;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.Application;
import com.ssm.entity.ApplyCount;

import javax.json.JsonObject;
import java.util.List;

public interface ApplicationService {
    /**
     * 根据id
     * @param applyId
     * @return
     */
    int deleteApplyFrom(String applyId);


   JSONObject submit_application(JSONObject request);
    /**
     * 退订
     * @param applyId
     * @return
     */
    int returnApplyForm(String applyId);

    /**
     * 预定会议室/添加
     * @param application
     * @return
     */
    int addApplyFrom(Application application)throws Exception;

    /**
     * 批量删除
     * @param applyIds
     * @return
     */
    int deleteApplyFrom(List<String> applyIds);

    /**
     * 修改
     * @param application
     * @return
     */
    int updateApplyById(Application application);

    /**
     * 查询所有状态
     * @return
     */
    ApplyCount getStateNum();
}
