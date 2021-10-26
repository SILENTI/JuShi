package com.example.jushi.controller;

import com.example.jushi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/JuShi")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/Login")
    public String login (@RequestParam("userName") String username, @RequestParam("passWord") String password, Model model){
        System.out.println(username +" " +password);
        Boolean judge = userService.judegUser(username,password,model);
        if (judge){
            System.out.println("登录成功！！");
            //跳转到主页
            return "GoodsShow";
        }
        return "Login";
    }

}
