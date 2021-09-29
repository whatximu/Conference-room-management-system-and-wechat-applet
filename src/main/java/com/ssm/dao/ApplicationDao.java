package com.ssm.dao;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.Application;
import com.ssm.entity.solttime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Repository
public interface ApplicationDao {
    /**
     * 根据id查询
     * @param applyId
     * @return
     */
    @Select("SELECT * FROM application WHERE is_available=1 AND apply_id=#{applyId}")
    Application getApplyById(@Param("applyId") String applyId);





    /**
     * 根据会议室ID查询
     * @return
     */
    @Select("SELECT * FROM application WHERE room_id=#{roomId} AND is_available=1")
    List<Application> getApplyByRoomId(@Param("roomId") Integer roomId);


    @Select("SELECT id FROM room\n" +
            "where room_name=#{name}")
    String getroomid(@Param("name") String name);


    @Insert("INSERT INTO application(apply_id,emp_id,room_id,content,meet_num,apply_date,start_time,end_time) VALUES('${apply_id}','${emp_id}','${roomid}','${content}','${people}','${apply_date}','${start_time}','${end_time}')")
    void submit_application(JSONObject request);


    /**
     * 添加申请表（申请使用会议室）
     * @param application
     * @return
     */
    @Insert("INSERT INTO application(apply_id,emp_id,room_id,content,meet_num,start_time,end_time,apply_date)\n" +
            "VALUES(#{applyId},#{empId},#{roomId},#{content},#{meetNum},#{startTime},#{endTime},#{applyDate})")
    int addApplyFrom(Application application);


    /**
     * 删除订单
     * @param applyId
     * @return
     */
    @Update("UPDATE application SET is_available=0\n" +
            "WHERE apply_id=#{applyId}")
    int deleteApplyFrom(@Param("applyId") String applyId);

    /**
     * 退订
     * @param applyId
     * @return
     */
    @Update("UPDATE application SET state=1\n" +
            "WHERE apply_id=#{applyId}")
    int returnApplyForm(@Param("applyId") String applyId);

    /**
     * 根据id修改
     * @param application
     * @return
     */
    @Update("UPDATE application SET room_id=#{roomId},content=#{content},meet_num=#{meetNum}," +
            "start_time=#{startTime},end_time=#{endTime},apply_date=#{applyDate} WHERE apply_id=#{applyId}")
    int updateApplyById(Application application);

    /**
     * 查询大会议室使用次数
     * @return
     */
    @Select("SELECT COUNT(*) \n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "WHERE r.room_name LIKE '%大会议室%'\n" +
            "AND r.is_available=1\n" +
            "AND a.is_available=1 AND a.state=0")
    int selectStateZero();

    /**
     * 查询中型会议室使用数量
     * @return
     */
    @Select("SELECT COUNT(*) \n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "WHERE r.room_name LIKE '%中型会议室%'\n" +
            "AND r.is_available=1\n" +
            "AND a.is_available=1 AND a.state=0")
    int selectStateOne();

    /**
     * 查询小会议室的使用次数
     * @return
     */
    @Select("SELECT COUNT(*) \n" +
            "FROM application a\n" +
            "INNER JOIN room r ON r.id=a.room_id\n" +
            "WHERE r.room_name LIKE '%小会议室%'\n" +
            "AND r.is_available=1\n" +
            "AND a.is_available=1\n" +
            "AND a.state=0")
    int selectStateTwo();

    /**
     * 所有申请
     * @return
     */
    @Select("SELECT COUNT(*) FROM application WHERE is_available=1 AND state=0")
    int selectStateAll();


}
