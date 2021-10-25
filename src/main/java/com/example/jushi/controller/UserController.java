package com.example.jushi.controller;

import com.example.jushi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class UserController {

    @Autowired
    private UserService userService;

    public String login (String username, String password, Model model){
        return "";
    }
}
