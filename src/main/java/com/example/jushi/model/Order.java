package com.example.jushi.model;

import java.util.Date;

public class Order {
    private Long id;

    private Long oId;

    private Date oTime;

    private String oIdList;

    private Integer uId;

    private String oSite;

    private String oRemarks;

    private String received1;

    private String received2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
        this.oId = oId;
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public String getoIdList() {
        return oIdList;
    }

    public void setoIdList(String oIdList) {
        this.oIdList = oIdList;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getoSite() {
        return oSite;
    }

    public void setoSite(String oSite) {
        this.oSite = oSite;
    }

    public String getoRemarks() {
        return oRemarks;
    }

    public void setoRemarks(String oRemarks) {
        this.oRemarks = oRemarks;
    }

    public String getReceived1() {
        return received1;
    }

    public void setReceived1(String received1) {
        this.received1 = received1;
    }

    public String getReceived2() {
        return received2;
    }

    public void setReceived2(String received2) {
        this.received2 = received2;
    }
}