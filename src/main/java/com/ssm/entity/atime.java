package com.ssm.entity;


public class atime {
    private  String applydata;
    private String starttime;
    private String endtime;

    public atime(String applydata, String starttime,String endtime) {
        this.applydata = applydata;
        this.starttime = starttime;
        this.endtime=endtime;
    }

    public String getApplydata() {
        return applydata;
    }

    public void setApplydata(String applydata) {
        this.applydata = applydata;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStart_time(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "atime{" +
                "applydata=" + applydata +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                '}';
    }
}
