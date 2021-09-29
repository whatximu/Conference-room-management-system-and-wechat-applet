package com.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.Room;
import com.ssm.entity.equip_info;
import com.ssm.service.impl.RoomServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@Controller
public class RoomController {
    @Autowired
    private RoomServiceImpl roomService;

       /**
     * 获取所有会议室信息（分页）
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllRoom")
    public PageInfo getAllRoom(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        List<Room> rooms = roomService.getAllRoom();
        //分页查询，传入页码和每页数据的个数
        PageHelper.startPage(pn,8);
        //使用pageinfo包装查询后的结果,连续显示的页数
        PageInfo pageInfo = new PageInfo(rooms,5);
        return pageInfo;
    }


    @ResponseBody
    @RequestMapping(value="/getRoom_solt_State", method = RequestMethod.POST)
    public JSONObject getRoomByState(@RequestBody JSONObject request){

        return roomService.wxgetRoom_time(request);
    }
    @ResponseBody
    @RequestMapping(value="/getRoom_solt_State2", method = RequestMethod.POST)
    public JSONObject getRoomByState2(@RequestBody JSONObject request){

        return roomService.wxgetRoom_time2(request);
    }



    //小程序端  会议室信息获取
    @ResponseBody
    @RequestMapping(value = "/wxgetAllRoom",method = RequestMethod.GET)
    public JSONObject getwxAllRoom() {

        return roomService.getwxAllRoom();
    }



    //小程序端  会议室设备信息获取
    @ResponseBody
    @RequestMapping(value = "/wxgetAllRoom_equip_info",method = RequestMethod.GET)
    public JSONObject getwxAllRoom_equip_info() {

        return roomService.getAllRoom_equip_info();
    }

    //小程序端  会议室信息获取
    @ResponseBody
    @RequestMapping(value = "/wxgetAllRoom2",method = RequestMethod.GET)
    public JSONObject getwxAllRoom_name() {

        return roomService.wxgetAllRoom();
    }

    @ResponseBody
    @RequestMapping(value = "/wxgetRoom_time",method = RequestMethod.GET)
    public JSONObject getRoom_time() {

        return roomService.wxgetRoom_time();
    }



    /**
     * 查询所有的会议室
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRoomState")
    public List<Room> getRoomByState(){
        List<Room> rooms = roomService.getAllRoom();
        return rooms;
    }

    /**
     * 添加会议室
     * @param room
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addRoom",method = RequestMethod.GET)
    public int addRoom(Room room){
        int result = roomService.addRoom(room);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/getRoom/{id}",method = RequestMethod.GET)
    public Room getRoomById(@PathVariable("id") Integer id){
        return roomService.getRoomById(id);
    }


    @ResponseBody
    @RequestMapping(value = "/getRoom_equipinfo/{id}",method = RequestMethod.GET)
    public equip_info getRoomById(@PathVariable("id") String id){
        return roomService.getRoomEquipById(id);
    }





    /**
     * 会议室修改
     * @param room
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateRoom/{id}",method = RequestMethod.POST)
    public int updateRoom(Room room){
        int result = roomService.updateRoomById(room);
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/updateRoom_equipinfo",method = RequestMethod.POST)
    public int updateRoom_equipinfo(@RequestBody JSONObject request){
        int result = roomService.updateRoomEquipinfoById(request);
        return result;
    }
    /**
     * 删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteRoom/{ids}",method = RequestMethod.POST)
    public int deleteRoom(@PathVariable("ids") String ids){
        int code = 0;
        int result = 0;
        if (ids.contains("-")){
            List<Integer> delIds = new ArrayList<>();
            String[] strIds = ids.split("-");
            for (String id:strIds) {
                delIds.add(Integer.parseInt(id));
            }
            result = roomService.deleteRoom(delIds);
            if (result>0){
                code = 1;
            }
        }else {
            Integer id = Integer.parseInt(ids);
            result = roomService.deleteRoomById(id);
            if (result > 0){
                code = 1;
            }
        }
        return code;
    }
}
