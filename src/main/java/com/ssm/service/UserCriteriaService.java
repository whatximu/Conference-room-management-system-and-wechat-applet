package com.ssm.service;

import com.ssm.entity.UserCriteria;

import java.util.List;


public interface UserCriteriaService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<UserCriteria> getAllUserMsg();
}
