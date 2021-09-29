package com.ssm.dao;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.Room;
import com.ssm.entity.equip_info;
import com.ssm.entity.atime;
import com.ssm.entity.solttime;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


@Repository

public interface RoomDao {
    /**
     * 查询所有会议室
     * @return
     */
    @Select("SELECT * FROM room WHERE is_available=1")
    List<Room> getAllRoom();
    @Select("SELECT room_name FROM room WHERE state !=1")
    String[] getAllRoom2();

    /**
     * 查询可使用的会议室
     * @return
     */
    @Select("SELECT * FROM room WHERE is_available=1")
    List<Room> getRoomByState();

    /**
     *
     */



    /**
     * xcx查询会议室占用
     * @return
     */
    @Select("SELECT\n" +
            "\tapplication.apply_date, \n" +
            "\tapplication.start_time, \n" +
            "\tapplication.end_time\n" +
            "FROM\n" +
            "\troom\n" +
            "\tINNER JOIN\n" +
            "\tapplication\n" +
            "\tON \n" +
            "\t\troom.id = application.room_id\n" )
//            "where room.room_name=\'2B201\'")
    List<atime> getRoom_un_info();

    @Select("SELECT  UNIX_TIMESTAMP(concat(\n" +
            "\tapplication.apply_date, ' ',\n" +
            "\tapplication.start_time)) * 1000 AS timeStamp,\n" +
            "\tapplication.state AS statue\n" +
            "FROM\n" +
            "\tapplication\n" +
            "\tINNER JOIN\n" +
            "\troom\n" +
            "\tON \n" +
            "\t\tapplication.room_id = room.id\n" +
            "\t\t\n" +
            "where room.room_name='${room_name}' and application.state!='2'")
    String[] get_solt_time(JSONObject request);
    @Select("SELECT  UNIX_TIMESTAMP(concat(\n" +
            "\tapplication.apply_date, ' ',\n" +
            "\tapplication.end_time)) * 1000-1800000 AS timeStamp,\n" +
            "\tapplication.state AS statue\n" +
            "FROM\n" +
            "\tapplication\n" +
            "\tINNER JOIN\n" +
            "\troom\n" +
            "\tON \n" +
            "\t\tapplication.room_id = room.id\n" +
            "\t\t\n" +
            "where room.room_name='${room_name}' and application.state!='2'")
    String[] get_solt_time2(JSONObject request);




    /**
     * wx查询会议室设备情况
     * @return
     */
    @Select("SELECT * FROM equipment_info ")
    List<equip_info> getAllRoom_equip_info();


    /**
     * 根据id查询会议室
     * @param id
     * @return
     */
    @Select("SELECT * FROM room WHERE is_available=1 AND id=#{id}")
    Room getRoomById(@Param("id") Integer id);
    @Select("SELECT * FROM equipment_info WHERE id=#{id}")
    equip_info getRoomEquipById(@Param("id") String id);

    /**
     * 增加会议室
     * @param room
     * @return
     */
    @Insert("INSERT INTO room(room_name,location,population,device) VALUES(#{roomName},#{location},#{population},#{device})")
    int addRoom(Room room);

    /**
     * 根据id删除会议室
     * @param id
     * @return
     */
    @Update("UPDATE room SET is_available=0 WHERE id=#{id}")
    int deleteRoomById(@Param("id") Integer id);

    /**
     * 根据id修改会议室信息
     * @param room
     * @return
     */
    @Update("update room set room_name=#{roomName},location=#{location},population=#{population},device=#{device},state=#{state} where id=#{id}")
    int updateRoomById(Room room);
    @Update("update equipment_info set info=#{info},state=#{state} where id=#{id}")
    int updateRoomEquipinfoById(JSONObject request);

    /**
     * 根据id修改会议室的状态变为以预定
     * @param id
     * @return
     */
    @Update("UPDATE room SET state=1 WHERE id=#{id}")
    int usedRoomState(@Param("id") Integer id);

    /**
     * 将会议室状态变为可用
     * @param id
     * @return
     */
    @Update("UPDATE room SET state=0 WHERE id=#{id}")
    int freeRoomState(@Param("id") Integer id);

}
