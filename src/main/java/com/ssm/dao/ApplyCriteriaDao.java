package com.ssm.dao;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.Application;
import com.ssm.entity.ApplyCriteria;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApplyCriteriaDao {
    /**
     * 查询所有信息
     * @return
     */
    @Select("SELECT a.*,r.room_name,u.emp_name\n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "INNER JOIN user u ON u.emp_id=a.emp_id\n" +
            "WHERE a.is_available=1\n" +
            "AND r.is_available=1\n" +
            "AND u.is_available=1")
    List<ApplyCriteria> getApplication();
    @Select("SELECT a.*,r.room_name,u.emp_name\n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "INNER JOIN user u ON u.emp_id=a.emp_id\n" +
            "WHERE a.is_available=1\n" +
            "AND r.is_available=1\n" +
            "AND a.room_id=#{room}\n" +
            "AND u.is_available=1")
    List<ApplyCriteria> getApplication21(JSONObject request);
    /**
     * 根据id查询
     * @param applyId
     * @return
     */
    @Select("SELECT a.*,r.room_name,u.emp_name\n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "INNER JOIN user u ON u.emp_id=a.emp_id\n" +
            "WHERE a.is_available=1\n" +
            "AND r.is_available=1\n" +
            "AND u.is_available=1\n" +
            "AND a.apply_id=#{applyId}")
    ApplyCriteria getApplicationById(@Param("applyId") String applyId);

    /**
     * 根据员工id查询订单
     * @param empId
     * @return
     */
    @Select("SELECT a.*,r.room_name,u.emp_name\n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "INNER JOIN user u ON u.emp_id=a.emp_id\n" +
            "WHERE a.is_available=1\n" +
            "AND r.is_available=1\n" +
            "AND u.is_available=1\n" +
            "AND a.emp_id=#{empId}\n" +
            "ORDER BY a.apply_date DESC")
    List<ApplyCriteria> getAppByEmpId(@Param("empId") Integer empId);




    /**
     * 根据申请日期查询订单
     * @param applyDate
     * @param sevenLater
     * @return
     */
    @Select("SELECT a.*,r.room_name\n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "WHERE a.state in(0,2)\n" +
            "AND a.is_available=1\n" +
            "AND r.is_available=1\n" +
            "AND a.apply_date BETWEEN #{applyDate} AND #{sevenLater} \n" +
            "ORDER BY CONCAT(a.apply_date,a.room_id)")
    List<ApplyCriteria> getApplyByApplyDate(@Param("applyDate") String applyDate,@Param("sevenLater") String sevenLater);

    /**
     * 根据日期查询
     * @param applyDate
     * @return
     */
    @Select("SELECT a.*,r.room_name\n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "WHERE a.state=0\n" +
            "AND a.is_available=1\n" +
            "AND r.is_available=1\n" +
            "AND a.apply_date=#{applyDate}\n" +
            "ORDER BY a.start_time")
    List<ApplyCriteria> getDateTime(@Param("applyDate") String applyDate);
    /**
     * 添加空白订单
     * @param application
     * @return
     */
    @Insert("INSERT INTO application(room_id,start_time,end_time,apply_date,state)\n" +
            "VALUES(#{roomId},#{startTime},#{endTime},#{applyDate},#{state})")
    int addBlankRoom(Application application);

    /**
     * 删除空订单
     * @return
     */
    @Delete("DELETE FROM application WHERE state=2")
    int deleteBlankRoom();
}
