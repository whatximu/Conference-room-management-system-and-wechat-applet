package com.ssm.service;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.User;
import com.ssm.entity.admin;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @return
     */
    User login(String userName, String passWord);

    /**
     * wxxcx用户登录
     * @param request
     * @return
     */

    JSONObject wxuserLogin(JSONObject request);


    /**
     * wxxcx根据id查询已预约订单
     * @param request
     * @return
     */
    JSONObject wxgetAppByEmpId( JSONObject request);
    /**
     * wxxcx根据id查询正在进行订单
     * @param request
     * @return
     */
    JSONObject wxgetAppByEmpId2( JSONObject request);
    /**
     * wxxcx根据id查询已结束订单
     * @param request
     * @return
     */
    JSONObject wxgetAppByEmpId5( JSONObject request);
    JSONObject wxgetAppByEmpId3( JSONObject request);
    JSONObject wxdelorder( JSONObject request);
    JSONObject wxgetnotice( JSONObject request);
    JSONObject wxgetnoticeshow1( JSONObject request);
    JSONObject wxgetnoticeshow2( JSONObject request);
    JSONObject wxgetnoticeshow_num(JSONObject request);
    JSONObject updateEmpId ( JSONObject request);

    JSONObject change_show_state ( JSONObject request);

    /**
     * wxxcx用户修改密码
     * @param request
     * @return
     */
    JSONObject wxchangepwd( JSONObject request);






    /**
     * 管理员登录
     * @param userName
     * @param passWord
     * @return
     */
    User adminLogin(String userName, String passWord);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 添加/注册用户
     * @param user
     * @return
     */
    int addUser(User user);
    /**
     * 根据id修改用户
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 单个删除
     * @param id
     * @return
     */
    int deleteUserById(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteUser(List<Integer> ids);

    /**
     * 修改密码
     * @param userName
     * @param newPwd
     * @param oldPwd
     * @return
     */
    int updatePassWord(String userName,String newPwd,String oldPwd);
}
