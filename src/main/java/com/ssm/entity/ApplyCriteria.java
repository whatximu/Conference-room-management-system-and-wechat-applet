package com.ssm.entity;

import java.util.Date;


public class ApplyCriteria {
    /**
     * 申请表id
     */
    private String applyId;
    /**
     * 员工id
     */
    private Integer empId;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 会议室id
     */
    private Integer roomId;
    /**
     * 会议室名称
     */
    private String roomName;
    /**
     * 申请内容
     */
    private String content;
    /**
     * 参加人数
     */
    private Integer meetNum;
    /**
     * 申请日期
     */
    private String applyDate;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 状态，默认0已预定，1为取消
     */
    private Integer state;
    /**
     * 有效状态
     */
    private Integer isAvailable;

    public ApplyCriteria() {
    }

    public ApplyCriteria(String applyId, Integer empId, String empName, Integer roomId, String roomName, String content,
                         Integer meetNum, String applyDate, String startTime, String endTime, Integer state, Integer isAvailable) {
        this.applyId = applyId;
        this.empId = empId;
        this.empName = empName;
        this.roomId = roomId;
        this.roomName = roomName;
        this.content = content;
        this.meetNum = meetNum;
        this.applyDate = applyDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
        this.isAvailable = isAvailable;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMeetNum() {
        return meetNum;
    }

    public void setMeetNum(Integer meetNum) {
        this.meetNum = meetNum;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    @Override
    public String toString() {
        return "ApplyCriteria{" +
                "applyId='" + applyId + '\'' +
                ", empId=" + empId +
                ", empName='" + empName + '\'' +
                ", roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", content='" + content + '\'' +
                ", meetNum=" + meetNum +
                ", applyDate='" + applyDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", state=" + state +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
