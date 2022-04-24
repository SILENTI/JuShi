package com.example.jushi.vo;

import java.io.Serializable;

/**
 * @author 居無何
 * date: 2022/4/22 15:31
 * Description: 传输的秒杀消息体
 */
public class SeckillMessage implements Serializable {

    private Integer Uid;

    private Integer Sid;

    private Integer Aid;

    private Integer Num;

    private String UserName;

    public SeckillMessage() {
    }


    public SeckillMessage(Integer uid, Integer sid, Integer aid, Integer num, String userName) {
        Uid = uid;
        Sid = sid;
        Aid = aid;
        Num = num;
        UserName = userName;
    }

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    public Integer getSid() {
        return Sid;
    }

    public void setSid(Integer sid) {
        Sid = sid;
    }

    public Integer getAid() {
        return Aid;
    }

    public void setAid(Integer aid) {
        Aid = aid;
    }

    public Integer getNum() {
        return Num;
    }

    public void setNum(Integer num) {
        Num = num;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "SeckillMessage{" +
                "Uid=" + Uid +
                ", Sid=" + Sid +
                ", Aid=" + Aid +
                ", Num=" + Num +
                ", UserName='" + UserName + '\'' +
                '}';
    }
}
