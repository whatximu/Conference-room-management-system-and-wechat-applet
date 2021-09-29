package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.UserCriteria;
import com.ssm.service.impl.UserCriteriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class UserCriteriaController {
    @Autowired
    private UserCriteriaServiceImpl userCriteriaService;

    /**
     * 查询所有用户信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllUserMsg")
    public PageInfo getAllUserMsg(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        List<UserCriteria> users = userCriteriaService.getAllUserMsg();
        PageHelper.startPage(pn,8);
        PageInfo pageInfo = new PageInfo(users,5);
        return pageInfo;
    }
}
