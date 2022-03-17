package com.example.jushi.service;

import com.example.jushi.model.User;
import com.example.jushi.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


/**
 * @author 居無何
 */
@Service
public interface IUserService {

    /**
     * 用户注册添加记录
     * @param user
     * @return 返回Boolean值，确认是否添加成功
     */
     void insertUser (User user);

    /**
     * 用户登录，根据前端传递过来的user对象
     * @param user
     * @return 若登录条件符合，返回user对象
     */
     User userLogin (User user);

    /**
     * 修改用户密码
     * @param uid
     * @param userName
     * @param oldPassword
     * @param newPassword
     */
    void changePassword (Integer uid,String userName,String oldPassword , String newPassword);

    /**
     * 更具uid查询到user信息
     * @param uid
     * @return User
     * */
    User findUserByUid (int uid);

    /**
     * 修改用户资料
     * @param user 有前端传递过来的所要修改的信息 phone,email,gender
     * @param session 从session中获取得到的User对象
     * @return User
     */
    User changeUserInfo (User user, HttpSession session);

    /**
     * 修改用户头像
     * @param uid 用户uid
     * @param avatar 用户头像的地址路径
     * @param username 修改头像的用户名
     */
    void changeAvatar(Integer uid, String avatar, String username);
}
