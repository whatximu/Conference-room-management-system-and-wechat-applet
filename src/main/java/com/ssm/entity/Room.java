package com.ssm.entity;

/**

 * 会议室表
 **/
public class Room {
    /**
     * 会议室id
     */
    private Integer id;
    /**
     * 会议室名称
     */
    private String roomName;
    /**
     * 会议室位置
     */
    private String location;
    /**
     * 状态,默认0可用，1已预订，2维护
     */
    private Integer state;
    /**
     * 容纳人数
     */
    private Integer population;
    /**
     * 设备
     */
    private String device;
    /**
     * 有效状态
     */
    private Integer isAvailable;

    public Room() {
    }

    public Room(Integer id, String roomName, String location, Integer state, Integer population, String device,
                Integer isAvailable) {
        this.id = id;
        this.roomName = roomName;
        this.location = location;
        this.state = state;
        this.population = population;
        this.device = device;
        this.isAvailable = isAvailable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", location='" + location + '\'' +
                ", state=" + state +
                ", population=" + population +
                ", device='" + device + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
