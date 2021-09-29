package com.ssm.entity;


public class notice_show {

    private  String applyid;

    public String getApplyid() {
        return applyid;
    }

    public void setApply_id(String applyid) {
        this.applyid = applyid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    private String starttime;


    public notice_show(String applyid,String starttime) {
        this.applyid = applyid;
        this.starttime=starttime;

    }
    @Override
    public String toString() {
        return "notice_show{" +
                "applyid=" + applyid +
                ", starttime='" + starttime + '\'' +
                '}';
    }

}
