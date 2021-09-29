package com.ssm.entity;

public class Department {
    /**
     * 部门id
     */
    private String id;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 有效状态
     */
    private Integer isAvailable;

    public Department() {
    }

    public Department(String id, String deptName, Integer isAvailable) {
        this.id = id;
        this.deptName = deptName;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}