package com.ssm.service.impl;

import com.ssm.dao.DepartmentDao;
import com.ssm.entity.Department;
import com.ssm.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> getDept() {
        return departmentDao.getDept();
    }

    @Override
    public int addDept(Department department) {
        if (StringUtils.isBlank(department.getId())){
            return 0;
        }
        if (StringUtils.isBlank(department.getDeptName())){
            return 0;
        }
        return departmentDao.addDept(department);
    }

    @Override
    public Department getDeptById(String id) {
        return departmentDao.getDeptById(id);
    }

    @Override
    public Department wxgetDeptById(String id) {
        return departmentDao.wxgetDeptById(id);
    }



    @Override
    public int updateDeptById(Department department) {
        if (StringUtils.isBlank(department.getId())){
            return 0;
        }
        if (StringUtils.isBlank(department.getDeptName())){
            return 0;
        }
        return departmentDao.updateDeptById(department);
    }

    @Override
    public int deleteDeptById(String id) {
        return departmentDao.deleteDeptById(id);
    }

    @Override
    public int deleteDept(List<String> ids) {
        int result = 0;
        if (ids.size() <= 0){
            return -1;
        }
        for (String id:ids) {
            result = departmentDao.deleteDeptById(id);
        }
        return result;
    }

}
