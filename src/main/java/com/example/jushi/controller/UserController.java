package com.example.jushi.controller;

import com.example.jushi.model.User;
import com.example.jushi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/JuShi")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/LoginJudge")
    public String login (String userName, String passWord, HttpSession session){
        Boolean judge = userService.judegUser(userName,passWord,session);
        if (judge){
            System.out.println("登录成功！！");
            //跳转到主页
            return "redirect:/JuShi/";
        }
        return "Login";
    }

    @GetMapping("/Login")
    public String mians (){
        return "Login";
    }

}
