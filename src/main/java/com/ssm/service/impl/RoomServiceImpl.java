package com.ssm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.RoomDao;
import com.ssm.entity.Room;
import com.ssm.entity.equip_info;
import com.ssm.entity.atime;
import com.ssm.entity.solttime;
import com.ssm.service.RoomService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.json.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;


    @Override
    public JSONObject wxgetRoom_time(JSONObject request) {
        JSONObject result = new JSONObject();
        try {



            String [] ax=roomDao.get_solt_time(request);

                result.put("ax",ax);
                result.put("statue", "0");



        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;
    }

    @Override
    public JSONObject wxgetRoom_time2(JSONObject request) {
        JSONObject result = new JSONObject();
        try {



            String [] ax=roomDao.get_solt_time2(request);

            result.put("ax",ax);
            result.put("statue", "0");



        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改异常！");

        }
        return result;
    }



    @Override
    public JSONObject wxgetAllRoom() {
        JSONObject result5 = new JSONObject();
        String[] a = roomDao.getAllRoom2();
        result5.put("data",a);
        return result5;
    }

    @Override
    public JSONObject wxgetRoom_time() {
        JSONObject result5 = new JSONObject();
        List<atime> a = roomDao.getRoom_un_info();

        result5.put("data",a);
        return result5;
    }

    @Override
    public List<Room> getAllRoom() {
        return roomDao.getAllRoom();
    }

    @Override
    public List<equip_info> getAllRoom_equip_info2() {
        return roomDao.getAllRoom_equip_info();
    }

    /**
     * wx 小程序  获取会议室
     * @return
     */
    @Override
    public JSONObject getwxAllRoom() {
        JSONObject result5 = new JSONObject();
        List<Room> a = roomDao.getAllRoom();
        result5.put("asd",a);
        return result5;
    }
    /**
     * wx 小程序  获取会议室设备信息
     * @return
     */
    @Override
    public JSONObject getAllRoom_equip_info() {
        JSONObject result5 = new JSONObject();
        List<equip_info> a = roomDao.getAllRoom_equip_info();
        result5.put("asd",a);
        return result5;

    }

    @Override
    public Room getRoomById(Integer id) {
        return roomDao.getRoomById(id);
    }

    @Override
    public equip_info getRoomEquipById(String id) {
        return roomDao.getRoomEquipById(id);
    }

    @Override
    public int addRoom(Room room) {
        if (StringUtils.isBlank(room.getRoomName())){
            return 0;
        }
        if (StringUtils.isBlank(room.getLocation())){
            return 0;
        }
        return roomDao.addRoom(room);
    }

    @Override
    public int updateRoomById(Room room) {
        if (StringUtils.isBlank(room.getRoomName())){
            return 0;
        }
        if (StringUtils.isBlank(room.getLocation())){
            return 0;
        }
        return roomDao.updateRoomById(room);
    }


    @Override
    public int updateRoomEquipinfoById(JSONObject request) {

        return roomDao.updateRoomEquipinfoById(request);
    }


    @Override
    public int freeRoomState(Integer id) {
        return roomDao.freeRoomState(id);
    }

    @Override
    public int deleteRoomById(Integer id) {
        return roomDao.deleteRoomById(id);
    }

    @Override
    public int deleteRoom(List<Integer> ids) {
        int result = 0;
        if (ids.size() <= 0){
            return -1;
        }
        for (Integer id:ids) {
            result = roomDao.deleteRoomById(id);
        }
        return result;
    }
}
