package com.ssm.entity;

import java.util.Date;


public class Application {
    /**
     * 申请表id
     */
    private String applyId;
    /**
     * 员工id
     */
    private Integer empId;
    /**
     * 会议室id
     */
    private Integer roomId;
    /**
     * 申请内容
     */
    private String content;
    /**
     * 参加人数
     */
    private Integer meetNum;
    /**
     * 订单日期
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
     * 状态，默认0为预定，1为取消订单
     */
    private Integer state;
    /**
     * 有效状态
     */
    private Integer isAvailable;

    public Application() {
    }

    public Application(String applyId, Integer empId, Integer roomId, String content, Integer meetNum, String applyDate,
                       String startTime, String endTime, Integer state, Integer isAvailable) {
        this.applyId = applyId;
        this.empId = empId;
        this.roomId = roomId;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
        return "Application{" +
                "applyId='" + applyId + '\'' +
                ", empId=" + empId +
                ", roomId=" + roomId +
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
