package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.Role;
import com.ssm.service.impl.RoleServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@Controller
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    /**
     * 查询所有权限
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRole")
    public PageInfo getRole(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        List<Role> roles = roleService.getRole();
        //分页查询，传入页码和每页数据的个数
        PageHelper.startPage(pn,8);
        //使用pageinfo包装查询后的结果,连续显示的页数
        PageInfo pageInfo = new PageInfo(roles,5);
        return pageInfo;
    }

    /**
     * 查询权限除了管理人员
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRoleExcept")
    public List<Role> getRoleExceptAdmin(){
        return roleService.getRoleExceptAdmin();
    }

    /**
     * 根据id查询权限
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRole/{id}",method = RequestMethod.GET)
    public Role getRoleById(@PathVariable("id") Integer id){
        return roleService.getRoleById(id);
    }


    /**
     * wxxcx 根据id查询权限
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/wxgetRole",method = RequestMethod.GET)
    public Role wxgetRoleById(@Param("id") String id){
        return roleService.wxgetRoleById(id);
    }




    /**
     * 添加权限
     * @param role
     * @return
     */


    @ResponseBody
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public int addDept(Role role){
        int result = roleService.addRole(role);
        return result;
    }
    /**
     * 部门更新
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateRole/{id}",method = RequestMethod.POST)
    public int updateDept(Role role){
        int result = roleService.updateRoleById(role);
        return result;
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteRole/{ids}",method = RequestMethod.POST)
    public int deleteRole(@PathVariable("ids") String ids){
        int code = 0;
        int result = 0;
        if (ids.contains("-")){
            List<Integer> delIds = new ArrayList<>();
            String[] strIds = ids.split("-");
            for (String id:strIds) {
                delIds.add(Integer.parseInt(id));
            }
            result = roleService.deleteRole(delIds);
            if (result>0){
                code = 1;
            }
        }else {
            Integer id = Integer.parseInt(ids);
            result = roleService.deleteRoleById(id);
            if (result>0){
                code = 1;
            }
        }
        return code;
    }
}
