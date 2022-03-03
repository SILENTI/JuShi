package com.example.jushi.vo;

import com.example.jushi.model.User;

/**
 * @author 居無何
 * date: 2022/2/27 13:12
 * Description: 前端所需的vo对象
 */
public class UserVo {

    private Integer uid;

    private String username;

    private String phone;

    private String email;

    private Integer gender;

    private String avatar;

    public UserVo() {
    }

    public UserVo(User user) {
        this.uid = user.getUid();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.avatar = user.getAvatar();
    }

    public UserVo(Integer uid, String username, String phone, String email, Integer gender, String avatar) {
        this.uid = uid;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
