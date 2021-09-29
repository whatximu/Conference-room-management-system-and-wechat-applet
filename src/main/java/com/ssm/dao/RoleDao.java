package com.ssm.dao;

import com.ssm.entity.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleDao {
    /**
     * 查询所有权限角色
     * @return
     */
    @Select("SELECT * FROM role")
    List<Role> getRole();

    /**
     * 查询除了管理的权限
     * @return
     */
    @Select("SELECT * FROM role WHERE id!=1 AND id!=2")
    List<Role> getRoleExceptAdmin();

    /**
     * 根据id查询权限
     * @param id
     * @return
     */
    @Select("SELECT * FROM role where id=#{id}")
    Role getRoleById(@Param("id") Integer id);


    /**
     * wxxcx根据id查询权限
     * @param id
     * @return
     */
    @Select("SELECT * FROM role where id=#{id}")
    Role wxgetRoleById(@Param("id") String id);


    /**
     * 添加权限
     * @param role
     * @return
     */
    @Insert("INSERT INTO role(role_name) VALUES(#{roleName})")
    int addRole(Role role);

    /**
     * 修改权限名称
     * @param role
     * @return
     */
    @Update("update role set id=#{id},role_name=#{roleName} where id=#{id}")
    int updateRoleById(Role role);

    /**
     * 删除权限
     * @param id
     * @return
     */
    @Delete("DELETE FROM role WHERE id=#{id}")
    int deleteRoleById(@Param("id") Integer id);

}
