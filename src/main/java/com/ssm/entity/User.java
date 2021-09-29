package com.ssm.entity;


public class User {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 员工id
     */
    private Integer empId;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 有效状态
     */
    private Integer isAvailable;

    public User() {
    }

    public User(Integer id, String userName, String passWord, Integer empId, String empName, Integer roleId, String deptId, Integer isAvailable) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.empId = empId;
        this.empName = empName;
        this.roleId = roleId;
        this.deptId = deptId;
        this.isAvailable = isAvailable;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", empId=" + empId +
                ", empName='" + empName + '\'' +
                ", roleId=" + roleId +
                ", deptId=" + deptId +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
