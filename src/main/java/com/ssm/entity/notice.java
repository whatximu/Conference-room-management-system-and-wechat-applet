package com.ssm.entity;



public class notice {
    private String notice;


    public notice(String notice,String stealempid,String stealename,String time,String empid) {
        this.notice = notice;
        this.stealename = stealename;
        this.stealempid=stealempid;
        this.empid=empid;
        this.time=time;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    private String empid;

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getStealempid() {
        return stealempid;
    }

    public void setStealempid(String stealempid) {
        this.stealempid = stealempid;
    }

    public String getStealename() {
        return stealename;
    }

    public void setStealename(String stealename) {
        this.stealename = stealename;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String stealempid;
    private String stealename;
    private String time;
    @Override
    public String toString() {
        return "notice{" +
                "notice=" + notice +
                ", stealempid='" + stealempid + '\'' +
                ", stealename='" + stealename + '\'' +
                ", empid='" + empid + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

}
