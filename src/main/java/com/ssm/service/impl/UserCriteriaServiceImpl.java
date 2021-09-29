package com.ssm.service.impl;
import com.ssm.dao.UserCriteriaDao;
import com.ssm.entity.UserCriteria;
import com.ssm.service.UserCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserCriteriaServiceImpl implements UserCriteriaService {
    @Autowired
    private UserCriteriaDao userCriteriaDao;
    @Override
    public List<UserCriteria> getAllUserMsg() {
        return userCriteriaDao.getAllUserMsg();
    }
}
