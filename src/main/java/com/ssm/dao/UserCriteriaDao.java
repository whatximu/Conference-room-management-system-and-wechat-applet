package com.ssm.dao;

import com.ssm.entity.UserCriteria;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserCriteriaDao {
    /**
     * 查询所有用户信息
     * @return
     */
    @Select("SELECT u.*,r.role_name,d.dept_name\n" +
            "FROM user u\n" +
            "INNER JOIN department d ON d.id=u.dept_id\n" +
            "INNER JOIN role r ON r.id=u.role_id\n" +
            "WHERE u.is_available=1 \n" +
            "AND d.is_available=1")
    List<UserCriteria> getAllUserMsg();
}
