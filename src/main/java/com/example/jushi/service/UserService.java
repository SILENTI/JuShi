package com.example.jushi.service;

import com.example.jushi.model.User;
import com.example.jushi.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


/**
 * @author 居無何
 */
@Service
public interface UserService {

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
     UserVo userLogin (User user);

    /**
     * 判断所传递的用户名和密码是否存在
     * @param userName 用户名
     * @param passWord 密码
     * @param session 查询结果存在，存储到session中
     * @return Boolean
     * */
    Boolean judegUser ( String userName , String passWord , HttpSession session) ;

    /**
     * 修改用户密码
     * @param uid
     * @param userName
     * @param oldPassword
     * @param newPassword
     */
    void changePassword (Integer uid,String userName,String oldPassword , String newPassword);

    /**
     *
     * @param id
     * @return User
     * */
    User fandUserById (int id);
}
