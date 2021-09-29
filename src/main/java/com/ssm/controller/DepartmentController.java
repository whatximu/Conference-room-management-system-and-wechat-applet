package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.Department;
import com.ssm.service.impl.DepartmentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    /**
     * 查询所有部门
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDept")
    public PageInfo getDept(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        List<Department> departments = departmentService.getDept();
        PageHelper.startPage(pn,8);
        PageInfo pageInfo = new PageInfo(departments,5);
        return pageInfo;
    }

    /**
     * 添加部门
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addDept",method = RequestMethod.POST)
    public int addDept(Department department){
        int result = departmentService.addDept(department);
        return result;
    }

    /**
     * 根据id查部门信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getDept/{id}",method = RequestMethod.GET)
    public Department getDeptById(@PathVariable("id") String id){
        return departmentService.getDeptById(id);
    }


    /**
     * wxxcx根据id查部门信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/wxgetDept",method = RequestMethod.GET)
    public Department wxgetDeptById(@Param("id") String id){
        return departmentService.wxgetDeptById(id);
    }




    /**
     * 部门更新
     * @param department
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateDept/{id}",method = RequestMethod.POST)
    public int updateDept(Department department){
        int result = departmentService.updateDeptById(department);
        return result;
    }

    /**
     * 删除
     * 单个/批量
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteDept/{ids}",method = RequestMethod.POST)
    public int deleteDpet(@PathVariable("ids") String ids){
        int code = 0;
        int result = 0;
        if (ids.contains("-")){
            List<String> delIds = new ArrayList<>();
            String[] strIds = ids.split("-");
            for (String id:strIds) {
                delIds.add(id);
            }
            result = departmentService.deleteDept(delIds);
            if (result > 0){
                code = 1;
            }
        }else {
            String id = ids;
            result = departmentService.deleteDeptById(id);
            if (result>0){
                code = 1;
            }
        }

        return code;
    }
}
