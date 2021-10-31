package com.example.jushi.service;

import com.example.jushi.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;


/**
 * @author 居無何
 */
@Service
public interface UserService {

    /**
     * 判断所传递的用户名和密码是否存在
     * @param userName 用户名
     * @param passWord 密码
     * @param session 查询结果存在，存储到session中
     * @return Boolean
     * */
    Boolean judegUser ( String userName , String passWord , HttpSession session) ;

    /**
     *
     * @param id
     * @return User
     * */
    User fandUserById (int id);
}
