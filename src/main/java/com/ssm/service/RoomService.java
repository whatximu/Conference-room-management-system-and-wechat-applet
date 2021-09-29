package com.ssm.service;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.Room;
import com.ssm.entity.equip_info;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface RoomService {
    /**
     * 查询所有会议室
     * @return
     */

    JSONObject wxgetRoom_time(JSONObject request);
    JSONObject wxgetRoom_time2(JSONObject request);
    JSONObject wxgetAllRoom();
    JSONObject wxgetRoom_time();
    List<equip_info>getAllRoom_equip_info2();
    List<Room> getAllRoom();
    /**
     * 根据id查询会议室
     * @param id
     * @return
     */
    Room getRoomById(Integer id);

    equip_info getRoomEquipById(String id);

    /**
     * 添加会议室
     * @param room
     * @return
     */
    int addRoom(Room room);

    /**
     *
     * @return
     */
    JSONObject getwxAllRoom ();

    /**
     *
     * @return
     */
    JSONObject getAllRoom_equip_info();

    /**
     * 修改会议室
     * @param room
     * @return
     */
    int updateRoomById(Room room);
    int updateRoomEquipinfoById(JSONObject request);

    /**
     * 归还会议室
     * @param id
     * @return
     */
    int freeRoomState(Integer id);

    /**
     * 单个删除
     * @param id
     * @return
     */
    int deleteRoomById(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteRoom(List<Integer> ids);

}
