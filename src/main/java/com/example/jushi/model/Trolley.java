package com.example.jushi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 居無何
 */
public class Trolley implements Serializable {

    private Integer tid;

    private Integer uid;

    private Integer gid;

    private BigDecimal price;

    private Integer num;

    private String createdUser;

    private Date createTime;

    private String modifUser;

    private Date modifTime;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
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
        return "Trolley{" +
                "tid=" + tid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", price=" + price +
                ", num=" + num +
                ", createdUser='" + createdUser + '\'' +
                ", createTime=" + createTime +
                ", modifUser='" + modifUser + '\'' +
                ", modifTime=" + modifTime +
                '}';
    }
}