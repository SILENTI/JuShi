package com.example.jushi.model;

import lombok.Data;

import java.math.BigDecimal;


/**
 * @author 居無何
 */
public class Goods {
    private Integer id;

    private Integer gId;

    private String gName;

    private String gImg;

    private String gType;

    private BigDecimal gPrice;

    private Integer gStock;

    private Integer gSales;

    private String reserved2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }

    public Integer getgStock() {
        return gStock;
    }

    public void setgStock(Integer gStock) {
        this.gStock = gStock;
    }

    public Integer getgSales() {
        return gSales;
    }

    public void setgSales(Integer gSales) {
        this.gSales = gSales;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }
}