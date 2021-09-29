package com.ssm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.UserDao;
import com.ssm.entity.*;
import com.ssm.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String userName, String passWord) {
        User user = userDao.login(userName, passWord);
        return user;
    }

    /**
     *
     * @param request
     * wx user login
     * @return
     */
    @Override
    public JSONObject wxuserLogin(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            List<User> a=userDao.wxuserLogin(request);

            result.put("code", "0");
            result.put("data",a);
//            result.put("msg", "操作成功！");
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;
    }




    /**
     * wxxcx 根据id查询已预约
     * @param request
     * @return
     */
    @Override
    public JSONObject wxgetAppByEmpId(JSONObject request) {

             userDao.updateing();
             userDao.updateend();

        JSONObject result = new JSONObject();
        try {
            List<ApplyCriteria> a=userDao.wxgetAppByEmpId(request);

            result.put("code", "0");
            result.put("data",a);

        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;

    }


    @Override
    public JSONObject wxgetAppByEmpId2(JSONObject request) {

        userDao.updateing();
        userDao.updateend();

        JSONObject result = new JSONObject();
        try {
            List<ApplyCriteria> a=userDao.wxgetAppByEmpId2(request);

            result.put("code", "0");
            result.put("data",a);

        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;

    }



    @Override
    public JSONObject wxgetAppByEmpId3(JSONObject request) {

        userDao.updateing();
        userDao.updateend();

        JSONObject result = new JSONObject();
        try {
            List<ApplyCriteria> a=userDao.wxgetAppByEmpId3(request);

            result.put("code", "0");
            result.put("data",a);

        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;

    }



    @Override
    public JSONObject wxgetAppByEmpId5(JSONObject request) {

        userDao.updateing();
        userDao.updateend();

         String aa=userDao.get_role_id(request);
         request.put("role_id",aa);
        JSONObject result = new JSONObject();
        try {
            List<ApplyCriteria> a=userDao.wxgetAppByEmpId5(request);

            result.put("code", "0");
            result.put("data",a);

        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;

    }



    @Override
    public JSONObject wxdelorder(JSONObject request) {
        JSONObject result = new JSONObject();
        try {

            userDao.wxdelorder(request);
            result.put("data","ok");



        } catch (Exception e) {
            result.put("code", "500");
            result.put("data", "no");

        }
        return result;
    }

    @Override
    public JSONObject wxgetnotice(JSONObject request) {

        JSONObject result = new JSONObject();
        try {
            List<notice> a=userDao.wxgetnotice(request);

            result.put("code", "0");
            result.put("data",a);


        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;
    }



    @Override
    public JSONObject change_show_state(JSONObject request) {

        JSONObject result = new JSONObject();
        try {
            userDao.change_num_state(request);

            result.put("code", "0");
            result.put("data",0);


        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;
    }

    @Override
    public JSONObject wxgetnoticeshow1(JSONObject request) {

        JSONObject result = new JSONObject();
        try {
            List<notice_show> a=userDao.wxgetnoticeshow1(request);

            result.put("code", "0");
            result.put("data",a);


        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;
    }

    @Override
    public JSONObject wxgetnoticeshow_num(JSONObject request) {

        JSONObject result = new JSONObject();
        try {
            int a=userDao.get_read_num(request);

            result.put("code", "0");
            result.put("data",a);


        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;
    }

    @Override
    public JSONObject wxgetnoticeshow2(JSONObject request) {

        JSONObject result = new JSONObject();
        try {
            List<notice_show> a=userDao.wxgetnoticeshow2(request);

            result.put("code", "0");
            result.put("data",a);



        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;
    }





    @Override
    public JSONObject updateEmpId(JSONObject request) {
        JSONObject result = new JSONObject();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd- HH:mm:ss");

        String b=formatter.format(calendar.getTime());
        String apply_id=request.get("apply_id").toString();
        String notice="您的预约 "+apply_id+" 已被占用,实在抱歉";
        String a=userDao.get_role_id(request);
        request.put("notice",notice);
        request.put("time",b);
        userDao.insertNotice(request);
        userDao.updateEmpid(request);

        result.put("data", 0);
        return result;
    }

    @Override
    public JSONObject wxchangepwd(JSONObject request) {
        JSONObject result = new JSONObject();
        try {

                userDao.wxchangepwd(request);
                result.put("data","ok");

        } catch (Exception e) {
            result.put("code", "500");
            result.put("data", "no");

        }
        return result;
    }


    @Override
    public User adminLogin(String userName, String passWord) {
        return userDao.adminLogin(userName,passWord);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public int addUser(User user) {
        int result = 0;
        if (user.getUserName() == null || user.getUserName()==""){
            //没有用户名和密码
            return result;
        }
        if (user.getPassWord() == null || user.getPassWord()==""){
            return result;
        }
        if (StringUtils.isBlank(user.getDeptId())){
            return result;
        }
        if (StringUtils.isBlank(user.getEmpName())){
            return result;
        }
        if (user.getEmpId() == null){
            //员工id不存在
            return result;
        }
        User userByuserName = userDao.getUserByuserName(user.getUserName());
        if (userByuserName != null){
            //用户名已存在
            result = -2;
            return result;
        }else {
            userDao.deleteUser(user.getUserName());
        }
        User userByEmpId = userDao.getUserByEmpId(user.getEmpId());
        if (userByEmpId != null){
            //该员工ID已被使用
            result = -3;
            return result;
        }
        result = userDao.addUser(user);
        return result;
    }

    @Override
    public int updateUserById(User user) {
        if (user.getEmpId() == null){
            return 0;
        }
        if (StringUtils.isBlank(user.getEmpName())){
            return 0;
        }
        if (StringUtils.isBlank(user.getDeptId())){
            return 0;
        }
        if (user.getRoleId() == null){
            return 0;
        }
        return userDao.updateUserById(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public int deleteUser(List<Integer> ids) {
        int result = 0;
        if (ids.size()<=0){
            return -1;
        }
        for (Integer id:ids) {
            result = userDao.deleteUserById(id);
        }
        return result;
    }

    @Override
    public int updatePassWord(String userName, String newPwd, String oldPwd) {
        int result = 0;
        if (StringUtils.isBlank(userName)){
            return result;
        }
        if (StringUtils.isBlank(newPwd)){
            return result;
        }
        if (StringUtils.isBlank(oldPwd)){
            return result;
        }
        User login = userDao.login(userName, oldPwd);
        if (login == null){
            //用户不存在
            return -1;
        }

        result = userDao.updatePassword(userName,newPwd);
        return result;
    }
}
