package com.ssm.dao;


import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.json.JsonObject;
import java.util.List;


@Repository
public interface UserDao {
    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @return
     */
    @Select("select * from user where username=#{userName} and password=#{passWord} AND is_available=1")
    User login(@Param("userName") String userName, @Param("passWord") String passWord);

    /**
     * wx user login
     * @param request
     * @return
     */
    @Select("select * from user where username=#{userName} and password=#{passWord} AND is_available=1")
    List<User> wxuserLogin(JSONObject request);

    /**
     *
     */
    @Update("update  application set state='2'  where  application.apply_date =CURDATE()  and application.start_time<CURTIME()  and application.end_time>CURTIME() "
    )
    void updateing();

    /**
     *
     */
    @Update("update  application set state='3'  where  (application.apply_date =CURDATE()  and  application.end_time<CURTIME()) or application.apply_date <CURRENT_DATE() \n")
    void updateend();
    /**
     * wxxcx根据员工id查询订单
     * @param request
     * @return
     */
    @Select("SELECT a.*,r.room_name,u.emp_name\n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "INNER JOIN user u ON u.emp_id=a.emp_id\n" +
            "WHERE a.is_available=1 and a.state='0' \n" +
            "AND r.is_available=1\n" +
            "AND u.is_available=1\n" +
            "AND a.emp_id=#{empId}\n" +
            "ORDER BY a.apply_date DESC")
    List<ApplyCriteria> wxgetAppByEmpId(JSONObject request);

    @Select("SELECT a.*,r.room_name,u.emp_name\n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "INNER JOIN user u ON u.emp_id=a.emp_id\n" +
            "WHERE a.is_available=1 and a.state='2' \n" +
            "AND r.is_available=1\n" +
            "AND u.is_available=1\n" +
            "AND a.emp_id=#{empId}\n" +
            "ORDER BY a.apply_date DESC")
    List<ApplyCriteria> wxgetAppByEmpId2(JSONObject request);

    @Select("SELECT a.*,r.room_name,u.emp_name\n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "INNER JOIN user u ON u.emp_id=a.emp_id\n" +
            "WHERE a.is_available=1 and a.state='3' \n" +
            "AND r.is_available=1\n" +
            "AND u.is_available=1\n" +
            "AND a.emp_id=#{empId}\n" +
            "ORDER BY a.apply_date DESC")
    List<ApplyCriteria> wxgetAppByEmpId3(JSONObject request);

    @Select("SELECT a.*,r.room_name,u.emp_name\n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "INNER JOIN user u ON u.emp_id=a.emp_id\n" +
            "WHERE a.is_available=1 and a.state!='2' AND  a.emp_id in(select emp_id from user where user.role_id > '${role_id}')\n" +
            "AND r.is_available=1\n" +
            "AND u.is_available=1\n" +
//            "AND a.emp_id=#{empId}\n" +
            "ORDER BY a.apply_date DESC")
    List<ApplyCriteria> wxgetAppByEmpId5(JSONObject request);

    @Select("select role_id from user where emp_id='${emp_id}'")
    String get_role_id(JSONObject request);


    @Select("select * from notice where empid='${emp_id}'")
    List<notice> wxgetnotice(JSONObject request);

    @Select("select apply_id,start_time from notice_show where empip='${empId}' and state='1'")
    List<notice_show> wxgetnoticeshow1(JSONObject request);

    @Select("select apply_id,start_time from notice_show where empip='${empId}' and state='0' ")
    List<notice_show> wxgetnoticeshow2(JSONObject request);


    @Select("select count(empip)  from notice_show  where empip='${empId}' and state !=2 ")
    int get_read_num (JSONObject request);


    @Update("update notice_show set state='2'  where empip='${empId}' ")
    void change_num_state(JSONObject request);

    @Update(" update application set emp_id='${emp_id}' where apply_id='${apply_id}'")
    void  updateEmpid(JSONObject request);

    @Insert(" insert into notice values('${notice}','${emp_id}','${emp_name}','${emp_id2}','${time}')")
    void insertNotice(JSONObject request);



    /**
     * 管理员登录
     * @param userName
     * @param passWord
     * @return
     */
    @Select("SELECT * FROM user WHERE username=#{userName} AND password=#{passWord}  AND role_id IN(1,2) AND is_available=1 ")
    User adminLogin(@Param("userName") String userName, @Param("passWord") String passWord);




    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id} AND is_available=1")
    User getUserById(@Param("id") Integer id);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    @Select("SELECT * FROM user WHERE username=#{userName} AND is_available=1")
    User getUserByuserName(@Param("userName") String userName);

    /**
     * 根据员工ID查询用户
     * @param empId
     * @return
     */
    @Select("SELECT * FROM user WHERE emp_id=#{empId}")
    User getUserByEmpId(@Param("empId") Integer empId);

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Insert("INSERT INTO user(username,password,emp_id,role_id,emp_name,dept_id) VALUES(#{userName},#{passWord},#{empId},#{roleId},#{empName},#{deptId})")
    int addUser(User user);

    /**
     * 根据用户名修改密码
     * @param userName
     * @param passWord
     * @return
     */
    @Update("UPDATE user SET password=#{passWord} WHERE username=#{userName}")
    int updatePassword(@Param("userName") String userName,@Param("passWord") String passWord);



    /**
     * wxxcx用户修改密码

     * @return
     */
    @Update("UPDATE user SET password=#{newpwd} WHERE username=#{username} AND password=#{oldpwd} ")
    void wxchangepwd(JSONObject request);




    @Delete("delete from application  where apply_id='${orderid}' and emp_id='${empid}'")
    void wxdelorder(JSONObject request);


    /**
     * wxxcx检验用户旧密码

     * @return
     */
    @Update("SELECT password FROM user WHERE username=#{username}")
    String wxgetoldpwd(JSONObject request);



    /**
     * 根据id修改用户
     * @param user
     * @return
     */
    @Update("UPDATE user SET password=#{passWord},emp_id=#{empId},role_id=#{roleId},dept_id=#{deptId},emp_name=#{empName} WHERE id=#{id}")
    int updateUserById(User user);

    /**
     * 把用户变为无效数据
     * @param id
     * @return
     */
    @Update("UPDATE user SET is_available=0 WHERE id=#{id}")
    int deleteUserById(@Param("id") Integer id);

    /**
     * 删除
     * @param userName
     * @return
     */
    @Delete("DELETE FROM `user` WHERE username=#{userName}")
    int deleteUser(@Param("userName") String userName);
}
