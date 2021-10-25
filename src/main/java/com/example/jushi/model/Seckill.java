package com.example.jushi.model;

import java.math.BigDecimal;
import java.util.Date;

public class Seckill {
    private Long id;

    private Long gId;

    private Date sStart;

    private Date sEnd;

    private BigDecimal sPrice;

    private Integer sCount;

    private String reserved1;

    private String reserved2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public Date getsStart() {
        return sStart;
    }

    public void setsStart(Date sStart) {
        this.sStart = sStart;
    }

    public Date getsEnd() {
        return sEnd;
    }

    public void setsEnd(Date sEnd) {
        this.sEnd = sEnd;
    }

    public BigDecimal getsPrice() {
        return sPrice;
    }

    public void setsPrice(BigDecimal sPrice) {
        this.sPrice = sPrice;
    }

    public Integer getsCount() {
        return sCount;
    }

    public void setsCount(Integer sCount) {
        this.sCount = sCount;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }
}