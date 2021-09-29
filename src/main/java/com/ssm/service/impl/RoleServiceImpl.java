package com.ssm.service.impl;

import com.ssm.dao.RoleDao;
import com.ssm.entity.Role;
import com.ssm.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> getRole() {
        return roleDao.getRole();
    }

    @Override
    public List<Role> getRoleExceptAdmin() {
        return roleDao.getRoleExceptAdmin();
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Role wxgetRoleById(String id) {
        return roleDao.wxgetRoleById(id);
    }

//    @Override
//    public Role wxgetRoleById(int id) {
//        return roleDao.wxgetRoleById(id);
//    }

    @Override
    public int addRole(Role role) {
        if (StringUtils.isBlank(role.getRoleName())){
            return 0;
        }
        return roleDao.addRole(role);
    }

    @Override
    public int updateRoleById(Role role) {
        if (StringUtils.isBlank(role.getRoleName())){
            return 0;
        }
        return roleDao.updateRoleById(role);
    }

    @Override
    public int deleteRoleById(Integer id) {
        return roleDao.deleteRoleById(id);
    }

    @Override
    public int deleteRole(List<Integer> ids) {
        int result = 0;
        if (ids.size()<=0){
            return -1;
        }
        for (Integer id:ids) {
            result = roleDao.deleteRoleById(id);
        }
        return result;
    }
}
