package com.ssm.service;

import com.ssm.entity.Role;

import java.util.List;


public interface RoleService {
    /**
     * 查询所有权限角色
     * @return
     */
    List<Role> getRole();

    /**
     * 查询权限除了管理人员
     * @return
     */
    List<Role> getRoleExceptAdmin();
    /**
     * 根据id查询权限
     * @param id
     * @return
     */
    Role getRoleById(Integer id);



    /**
     * wxxcx根据id查询权限
     * @param id
     * @return
     */
    Role wxgetRoleById(String id);



    /**
     * 添加权限
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 修改权限名称
     * @param role
     * @return
     */
    int updateRoleById(Role role);

    /**
     * 删除权限
     * @param id
     * @return
     */
    int deleteRoleById(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteRole(List<Integer> ids);
}
