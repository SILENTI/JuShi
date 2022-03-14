package com.example.jushi.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 居無何
 */
public class Order {
    private Integer oid;

    private Integer uid;

    private String cneeName;

    private String cneePhone;

    private String cneeProvince;

    private String cneeCity;

    private String cneeDistrict;

    private String cneeAddress;

    private BigDecimal totalPrices;

    private Integer status;

    private Date orderTime;

    private Date payTime;

    private String createUser;

    private Date createTime;

    private String modifUser;

    private Date modifTime;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCneeName() {
        return cneeName;
    }

    public void setCneeName(String cneeName) {
        this.cneeName = cneeName == null ? null : cneeName.trim();
    }

    public String getCneePhone() {
        return cneePhone;
    }

    public void setCneePhone(String cneePhone) {
        this.cneePhone = cneePhone == null ? null : cneePhone.trim();
    }

    public String getCneeProvince() {
        return cneeProvince;
    }

    public void setCneeProvince(String cneeProvince) {
        this.cneeProvince = cneeProvince == null ? null : cneeProvince.trim();
    }

    public String getCneeCity() {
        return cneeCity;
    }

    public void setCneeCity(String cneeCity) {
        this.cneeCity = cneeCity == null ? null : cneeCity.trim();
    }

    public String getCneeDistrict() {
        return cneeDistrict;
    }

    public void setCneeDistrict(String cneeDistrict) {
        this.cneeDistrict = cneeDistrict == null ? null : cneeDistrict.trim();
    }

    public String getCneeAddress() {
        return cneeAddress;
    }

    public void setCneeAddress(String cneeAddress) {
        this.cneeAddress = cneeAddress == null ? null : cneeAddress.trim();
    }

    public BigDecimal getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(BigDecimal totalPrices) {
        this.totalPrices = totalPrices;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", cneeName='" + cneeName + '\'' +
                ", cneePhone='" + cneePhone + '\'' +
                ", cneeProvince='" + cneeProvince + '\'' +
                ", cneeCity='" + cneeCity + '\'' +
                ", cneeDistrict='" + cneeDistrict + '\'' +
                ", cneeAddress='" + cneeAddress + '\'' +
                ", totalPrices=" + totalPrices +
                ", status=" + status +
                ", orderTime=" + orderTime +
                ", payTime=" + payTime +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", modifUser='" + modifUser + '\'' +
                ", modifTime=" + modifTime +
                '}';
    }
}