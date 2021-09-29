package com.ssm.service;


import com.ssm.entity.Department;

import java.util.List;


public interface DepartmentService {
    /**
     * 获取所有部门
     * @return
     */
    List<Department> getDept();

    /**
     * 添加部门
     * @param department
     * @return
     */
    int addDept(Department department);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    Department getDeptById(String id);

    /**
     * wxxcx根据id查询部门
     * @param id
     * @return
     */
    Department wxgetDeptById(String id);





    /**
     * 根据id修改部门
     * @param department
     * @return
     */
    int updateDeptById(Department department);

    /**
     * 根据id删除部门
     * @param id
     * @return
     */
    int deleteDeptById(String id);

    /**
     * 全部删除
     * @return
     */
    int deleteDept(List<String> ids);
}
