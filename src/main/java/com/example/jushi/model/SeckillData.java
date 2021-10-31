package com.example.jushi.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 居無何
 */
public class SeckillData {

    private Integer gId;

    private String gName;

    private String gImg;

    private BigDecimal gPrice;

    private String gType;

    private Date sStart;

    private Date sEnd;

    private BigDecimal sPrice;

    private Integer sCount;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgImg() {
        return gImg;
    }

    public void setgImg(String gImg) {
        this.gImg = gImg;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
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

    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }
}
