package com.neuedu.demo.tijian.pojo.calendar;

public class CalendarResponse {
    private String ymd;
    private Integer total;
    private Integer existing;
    private Integer remainder; // 剩余天数

    public CalendarResponse() {}

    public CalendarResponse(String ymd, Integer total, Integer existing, Integer remainder) {
        this.ymd = ymd;
        this.total = total;
        this.existing = existing;
        this.remainder = remainder;
    }

    public String getYmd() {
        return ymd;
    }

    public void setYmd(String ymd) {
        this.ymd = ymd;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getExisting() {
        return existing;
    }

    public void setExisting(Integer existing) {
        this.existing = existing;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
    }
}
