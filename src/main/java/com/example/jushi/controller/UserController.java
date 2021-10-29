package com.example.jushi.controller;

import com.example.jushi.model.User;
import com.example.jushi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 居無何
 * */
@Controller
@RequestMapping("/JuShi")
public class UserController {

    @Autowired
    private UserService userService;

    /**用户信息查询，根据用户名和密码*/
    @PostMapping("/LoginJudge")
    public String login (String userName, String passWord, HttpSession session){
        Boolean judge = userService.judegUser(userName,passWord,session);
        if (judge){
            System.out.println("登录成功！！");
            //跳转到主页
            return "redirect:/";
        }
        return "redirect:Login";
    }

    /**转发登录请求*/
    @GetMapping("/Login")
    public String mians (){
        return "Login";
    }

}
