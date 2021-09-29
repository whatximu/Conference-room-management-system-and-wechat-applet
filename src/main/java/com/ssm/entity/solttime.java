package com.ssm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;



public class solttime {

    public String getTimeStamp() {
        return timeStamp;
    }

    public solttime(String timeStamp, String statue) {
        this.timeStamp = timeStamp;
        this.statue=statue;
    }



    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    private String timeStamp;
    private String statue;

    @Override
    public String toString() {
        return "solttime{" +
                "timeStamp=" + timeStamp +
                ", statue='" + statue + '\'' +
                '}';
    }
}
