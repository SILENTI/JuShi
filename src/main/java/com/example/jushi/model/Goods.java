package com.example.jushi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 居無何
 */
public class Goods implements Serializable {
    private Integer id;

    private Integer gId;

    private String gName;

    private String gType;

    private BigDecimal gPrice;

    private String gImg;

    private Integer gStock;

    private Integer gSales;

    private String gDescribe;

    private Integer gState;

    private String createUser;

    private Date createTime;

    private String modifUser;

    private Date modifTime;

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
        this.gName = gName == null ? null : gName.trim();
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType == null ? null : gType.trim();
    }

    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }

    public String getgImg() {
        return gImg;
    }

    public void setgImg(String gImg) {
        this.gImg = gImg == null ? null : gImg.trim();
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

    public String getgDescribe() {
        return gDescribe;
    }

    public void setgDescribe(String gDescribe) {
        this.gDescribe = gDescribe == null ? null : gDescribe.trim();
    }

    public Integer getgState() {
        return gState;
    }

    public void setgState(Integer gState) {
        this.gState = gState;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifUser() {
        return modifUser;
    }

    public void setModifUser(String modifUser) {
        this.modifUser = modifUser == null ? null : modifUser.trim();
    }

    public Date getModifTime() {
        return modifTime;
    }

    public void setModifTime(Date modifTime) {
        this.modifTime = modifTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", gId=" + gId +
                ", gName='" + gName + '\'' +
                ", gType='" + gType + '\'' +
                ", gPrice=" + gPrice +
                ", gImg='" + gImg + '\'' +
                ", gStock=" + gStock +
                ", gSales=" + gSales +
                ", gDescribe='" + gDescribe + '\'' +
                ", gState=" + gState +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", modifUser='" + modifUser + '\'' +
                ", modifTime=" + modifTime +
                '}';
    }
}