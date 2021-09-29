package com.ssm.entity;


public class UserCriteria {
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
     * 角色名称
     */
    private String roleName;
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 有效状态
     */
    private Integer isAvailable;

    public UserCriteria() {
    }

    public UserCriteria(Integer id, String userName, String passWord, Integer empId, String empName, Integer roleId,
                        String roleName, String deptId, String deptName, Integer isAvailable) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.empId = empId;
        this.empName = empName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.deptId = deptId;
        this.deptName = deptName;
        this.isAvailable = isAvailable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "UserCriteria{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", empId=" + empId +
                ", empName='" + empName + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
