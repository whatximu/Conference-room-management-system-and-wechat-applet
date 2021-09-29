package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.User;
import com.ssm.entity.admin;
import com.ssm.entity.equip_info;
import com.ssm.service.impl.RoomServiceImpl;
import com.ssm.service.impl.UserServiceImpl;
import com.ssm.util.ExcelUtil;
import com.ssm.util.Tool;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController

public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoomServiceImpl roomService;

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @param session
     * @return
     */
   @ResponseBody
   @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
   public int userLogin(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord,
                        HttpSession session){
       int result = 0;
       User user = userService.login(userName,passWord);

       if (user != null){
           session.setAttribute("user",user);
           result = 1;
       }else {
          result = -1;
       }
       return result;
   }


   //小程序  userlogin


    @RequestMapping(value = "/wxuserLogin",method = RequestMethod.POST)
    public JSONObject wxuserLogin(@RequestBody JSONObject request) {
        return userService.wxuserLogin(request);
    }

    /**
     * wxxcx根据员工id查询已预约
     *
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping(value="/getAllRoomEquip",method = RequestMethod.GET)
    public PageInfo getAllRoom_equipinfo(){
        List<equip_info> roomequip = roomService.getAllRoom_equip_info2();
        //分页查询，传入页码和每页数据的个数
        PageHelper.startPage(1,8);
        //使用pageinfo包装查询后的结果,连续显示的页数
        PageInfo pageInfo = new PageInfo(roomequip,5);
        return pageInfo;
    }
    @RequestMapping(value = "/wxgetAppByEmpId",method = RequestMethod.POST)
    public JSONObject getAppByEmpId(@RequestBody JSONObject request) {

        return userService.wxgetAppByEmpId(request);
    }
    @RequestMapping(value = "/wxgetAppByEmpId2",method = RequestMethod.POST)
    public JSONObject getAppByEmpId2(@RequestBody JSONObject request) {

        return userService.wxgetAppByEmpId2(request);
    }
    @RequestMapping(value = "/wxgetAppByEmpId3",method = RequestMethod.POST)
    public JSONObject getAppByEmpId3(@RequestBody JSONObject request) {

        return userService.wxgetAppByEmpId3(request);
    }


    @RequestMapping(value = "/wxgetAppByEmpId5",method = RequestMethod.POST)
    public JSONObject getAppByEmpId5(@RequestBody JSONObject request) {

        return userService.wxgetAppByEmpId5(request);
    }


    @RequestMapping(value = "/wxgetnotice",method = RequestMethod.POST)
    public JSONObject getnotice(@RequestBody JSONObject request) {

        return userService.wxgetnotice(request);
    }

    @RequestMapping(value = "/wxgetnoticeshow1",method = RequestMethod.POST)
    public JSONObject getnoticeshow1(@RequestBody JSONObject request) {

        return userService.wxgetnoticeshow1(request);
    }

    @RequestMapping(value = "/wxgetnoticeshow2",method = RequestMethod.POST)
    public JSONObject getnoticeshow2(@RequestBody JSONObject request) {

        return userService.wxgetnoticeshow2(request);
    }

    @RequestMapping(value = "/wxgetnoticeshow_num",method = RequestMethod.POST)
    public JSONObject getnoticeshow_num(@RequestBody JSONObject request) {

        return userService.wxgetnoticeshow_num(request);
    }



    @RequestMapping(value = "/updateEmpId",method = RequestMethod.POST)
    public JSONObject updateEmpId (@RequestBody JSONObject request) {

        return userService.updateEmpId(request);
    }

    @RequestMapping(value = "/change_show_state",method = RequestMethod.POST)
    public JSONObject change_num_state (@RequestBody JSONObject request) {

        return userService.change_show_state(request);
    }


    /**
     *
     * @param request
     * @return
     */

    @RequestMapping(value = "/wxchangepwd",method = RequestMethod.POST)
    public JSONObject wxchangepwd(@RequestBody JSONObject request) {

        return userService.wxchangepwd(request);
    }


    @RequestMapping(value = "/wxdelorder",method = RequestMethod.POST)
    public JSONObject wxdelorder(@RequestBody JSONObject request) {

        return userService.wxdelorder(request);
    }









    //退出
    @RequestMapping("/userLoginOut")
    @ResponseBody
    public int userLoginOut(HttpSession session){
        session.removeAttribute("user");
        if (session.getAttribute("user") == null){
            return 1;
        }
        return 0;
    }

















    /**
     * 管理员登录
     * @param userName
     * @param passWord
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    public int adminLogin(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord,
                         HttpSession session){
        int result = 0;
        User admin = userService.adminLogin(userName,passWord);

        if (admin != null){
            session.setAttribute("admin",admin);
            result = 1;
        }else {
            result = -1;
        }
        return result;
    }

    /**
     * 管理员退出
     * @param session
     * @return
     */
    @RequestMapping("/adminLoginOut")
    public ModelAndView adminLoginOut(HttpSession session){
        session.removeAttribute("admin");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.jsp");
        return mv;
    }
    /**
     * 根据id查用户信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    /**
     * 用户更新
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUser/{id}",method = RequestMethod.POST)
    public int updateUser(User user){
        int result = userService.updateUserById(user);
        return result;
    }

    /**
     * 添加/注册用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUser")
    public int addUser(User user){
        int result = userService.addUser(user);
        return result;
    }

    /**
     * 导入Excel
     * @param file
     * @param request
     * @throws IOException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException, InvalidFormatException {
        if (!file.isEmpty()){
            //获取upload文件夹的绝对路径
            String location = request.getServletContext().getRealPath("/fileload");
            String url = location + System.currentTimeMillis() + file.getOriginalFilename();
            file.transferTo(new File(url));
            File f1 = new File(url);
            String jsonStr = String.valueOf(ExcelUtil.readExcel(f1));

            //
            JSONArray jsonArray = JSON.parseArray(jsonStr);
            List<User> userList = new ArrayList<>();
            for (Object o:jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                String emp = jsonObject.getString("员工编号");
                int empId = Integer.parseInt(emp);
                String pwd = jsonObject.getString("密码");
                if (pwd.contains(".")){
                    pwd = pwd.substring(0,pwd.lastIndexOf("."));
                }
                float rol = jsonObject.getFloat("权限编号");
                int roleId = (int) rol;
                String userName = jsonObject.getString("用户名");
                String empName = jsonObject.getString("员工姓名");
                String deptId = jsonObject.getString("部门编号");
                User user = new User();
                user.setUserName(userName);
                user.setPassWord(pwd);
                user.setEmpId(empId);
                user.setRoleId(roleId);
                user.setEmpName(empName);
                user.setDeptId(deptId);
                userList.add(user);
            }
            for (User u:userList) {
                int result = userService.addUser(u);
            }
        }

        //
        return "redirect:user.jsp";
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUser/{ids}",method = RequestMethod.POST)
    public int deleteUser(@PathVariable("ids") String ids){
        int code = 0;
        int result = 0;
        if (ids.contains("-")){
            List<Integer> delIds = new ArrayList<>();
            String[] strIds = ids.split("-");
            for (String id:strIds) {
                delIds.add(Integer.parseInt(id));
            }
            result = userService.deleteUser(delIds);
            if (result > 0){
                code = 1;
            }
        }else {
            Integer id = Integer.parseInt(ids);
            result = userService.deleteUserById(id);
            if (result > 0){
                code = 1;
            }
        }
        return code;
    }

    /**
     * 修改密码
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping("/updatePwd")
    public int updatePassWord(@RequestParam("str") String data,HttpSession session){

        if (StringUtils.isBlank(data)){
            return 0;
        }
        Map<String, String> map = Tool.URLRequest(data);
        String userName = map.get("userName");
        String oldPwd = map.get("oldPwd");
        String newPwd = map.get("newPwd");
        int result = userService.updatePassWord(userName, newPwd, oldPwd);
        if (result > 0){
            session.removeAttribute("user");
        }
        return result;
    }

}
