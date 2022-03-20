package com.example.jushi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 居無何
 * date: 2022/3/20 15:29
 * Description:
 */
public class BaseEntity implements Serializable {

    private String createUser;

    private Date createTime;

    private String modifUser;

    private Date modifTime;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
        this.modifUser = modifUser;
    }

    public Date getModifTime() {
        return modifTime;
    }

    public void setModifTime(Date modifTime) {
        this.modifTime = modifTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", modifUser='" + modifUser + '\'' +
                ", modifTime=" + modifTime +
                '}';
    }

}
