package com.example.jushi.service;

import com.example.jushi.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;


@Service
public interface UserService {


    Boolean judegUser ( String userName , String passWord , HttpSession session) ;

    User fandUserById (int id);
}
