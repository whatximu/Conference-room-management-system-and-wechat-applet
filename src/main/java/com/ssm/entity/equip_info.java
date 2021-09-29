package com.ssm.entity;


public class equip_info {
   private String id;
    private String info;

    private String state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        if (info =="0") {
            info="正常";
        } else if(info =="1") {
            info="部分故障";
        } else if (info=="2"){
            info="损坏";
        }
        return info;
    }

    public void setInfo(String info) {

        this.info = info;
    }


    public void setState(String state) {

        this.state = state;
    }

    public String getState() {
        if (state =="0") {
            state="正常";
        } else if(state =="1") {
            state="已报修";
        } else if (state=="2"){
            state="正在维修";
        }
        return state;
    }


    public equip_info(String id, String info, String state) {
        this.id = id;
        this.info=info;
        this.state = state;

    }

    @Override
    public String toString() {
        return "equip_info{" +
                "id=" + id +
                ", info=" + info+
        ", state=" + state +


                '}';
    }


}
