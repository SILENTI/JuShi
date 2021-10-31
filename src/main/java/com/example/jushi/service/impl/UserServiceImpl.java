package com.example.jushi.service.impl;

import com.example.jushi.mapper.UserMapper;
import com.example.jushi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;


@Service
public class UserServiceImpl implements com.example.jushi.service.UserService {

    @Autowired
    private UserMapper userMapper;

    /**
    * 判断账号和密码是否正确
    * */
    @Override
    public Boolean judegUser (String userName , String passWord , HttpSession session) {
        System.out.println(userName+"  "+passWord);
          User realUser = userMapper.selectForUser(userName,passWord);
          if (realUser!=null && realUser.getUsername().equals(userName )&& realUser.getPassword().equals(passWord)){
              session.setAttribute("user",realUser);
              return true;
          }
        return false;
    }

    @Override
    public User fandUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
