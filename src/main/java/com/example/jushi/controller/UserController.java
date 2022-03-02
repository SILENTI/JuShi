package com.example.jushi.controller;

import com.example.jushi.model.User;
import com.example.jushi.service.UserService;
import com.example.jushi.util.JsonResult;
import com.example.jushi.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 居無何
 * */
@RestController
@RequestMapping("/jushi/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册，前端传递过来的注册的用户信息
     * @param user
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JsonResult<Void> userRegister (User user){

        userService.insertUser(user);

        //返回的JSON形式的数据
        return new JsonResult("注册成功");
    }

    /**
     * 用户登录
     * @param user
     * @return 将用户信息以JOSN形式返回
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult<UserVo> userLogin (HttpSession session, User user ){

       UserVo finduser = userService.userLogin(user);

       //将登录成功后所得到用户信息存储到session中
       //在此处可以优化，新建vo实体类，将一些重要的信息屏蔽掉，后将其传递给前端。

       if (finduser != null){
           session.setAttribute("user",finduser);
       }

       return new JsonResult<UserVo>(finduser,"登录成功");
    }

    /**
     * 用户密码修改
     * @param oldPassword
     * @param newPassword
     * @param session
     * @return
     */
    @RequestMapping(value = "/change_password",method = RequestMethod.POST)
    public JsonResult<Void> changePassword (String oldPassword,String newPassword,HttpSession session){

        //获取Session中的User
        UserVo userVo = (UserVo) session.getAttribute("user");

        userService.changePassword(userVo.getUid(),userVo.getUsername(),oldPassword,newPassword);

        return new JsonResult<>(200,"密码修改成功");
    }

}
