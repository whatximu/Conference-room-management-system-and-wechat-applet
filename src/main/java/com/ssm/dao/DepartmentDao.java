package com.ssm.dao;

import com.ssm.entity.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentDao {
    /**
     * 添加部门
     * @param department
     * @return
     */
    @Insert("INSERT INTO department(id,dept_name) VALUES(#{id},#{deptName})")
    int addDept(Department department);

    /**
     * 根据部门id修改部门信息
     * @param department
     * @return
     */
    @Update("update department set id=#{id},dept_name=#{deptName} where id=#{id}")
    int updateDeptById(Department department);

    /**
     * 删除部门
     * @param id
     * @return
     */
    @Update("UPDATE department SET is_available=0 WHERE id=#{id}")
    int deleteDeptById(@Param("id") String id);

    /**
     * 查询部门
     * @return
     */
    @Select("SELECT * FROM department WHERE is_available=1")
    List<Department> getDept();

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @Select("SELECT * FROM department WHERE is_available=1 AND id=#{id}")
    Department getDeptById(@Param("id") String id);

    /**
     * wxxcx根据id查询部门
     * @param id
     * @return
     */
    @Select("SELECT * FROM department WHERE is_available=1 AND id=#{id}")
    Department wxgetDeptById(@Param("id") String id);


}
