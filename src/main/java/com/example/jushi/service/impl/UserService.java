package com.example.jushi.service.impl;

import com.example.jushi.mapper.UserMapper;
import com.example.jushi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class UserService implements com.example.jushi.service.UserService {

    @Autowired
    private UserMapper userMapper;

    /*
    * 判断账号和密码是否正确
    * */
    @Override
    public Boolean judegUser (String userName , String passWord , Model model) {
//          User user = new User(userName,passWord);
          User realUser = userMapper.selectForUser(userName,passWord);
          if (realUser!=null && realUser.getUsername()==userName && realUser.getPassword() == passWord){
              model.addAttribute("user",realUser);
              return true;
          }
        return false;
    }
}
