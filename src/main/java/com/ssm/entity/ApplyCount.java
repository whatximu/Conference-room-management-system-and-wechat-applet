package com.ssm.entity;


public class ApplyCount {
    /**
     * 总记录数
     */
    private Integer all;
    /**
     * 大会议室次数
     */
    private Integer zero;
    /**
     * 中型会议室次数
     */
    private Integer one;
    /**
     * 小会议室次数
     */
    private Integer two;
    /**
     * 其他次数
     */
    private Integer three;

    public ApplyCount(Integer all, Integer zero, Integer one, Integer two, Integer three) {
        this.all = all;
        this.zero = zero;
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public ApplyCount() {
    }

    public Integer getZero() {
        return zero;
    }

    public void setZero(Integer zero) {
        this.zero = zero;
    }

    public Integer getOne() {
        return one;
    }

    public void setOne(Integer one) {
        this.one = one;
    }

    public Integer getTwo() {
        return two;
    }

    public void setTwo(Integer two) {
        this.two = two;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public Integer getThree() {
        return three;
    }

    public void setThree(Integer three) {
        this.three = three;
    }

    @Override
    public String toString() {
        return "ApplyCount{" +
                "all=" + all +
                ", zero=" + zero +
                ", one=" + one +
                ", two=" + two +
                ", three=" + three +
                '}';
    }
}
