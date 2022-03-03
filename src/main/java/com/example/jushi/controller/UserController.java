package com.example.jushi.controller;

import com.example.jushi.model.User;
import com.example.jushi.service.UserService;
import com.example.jushi.util.JsonResult;
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
    public JsonResult<User> userLogin (HttpSession session, User user ){

       User finduser = userService.userLogin(user);

       //将登录成功后所得到用户信息存储到session中
       //在此处可以优化，新建vo实体类，将一些重要的信息屏蔽掉，后将其传递给前端。

       if (finduser != null){
           session.setAttribute("user",finduser);
       }

       return new JsonResult<User>(finduser,"登录成功");
    }

    /**
     * 用户密码修改
     * @param oldPassword 用户原密码
     * @param newPassword 用户新密码
     * @param session
     * @return 返回响应码
     */
    @RequestMapping(value = "/change_password",method = RequestMethod.POST)
    public JsonResult<Void> changePassword (String oldPassword,String newPassword,HttpSession session){

        //获取Session中的User
        User user = (User) session.getAttribute("user");

        userService.changePassword(user.getUid(),user.getUsername(),oldPassword,newPassword);

        return new JsonResult<>(200,"密码修改成功");
    }

    /**
     * 查询用户信息资料
     * @param session
     * @return
     */
    @RequestMapping("/user/user_info")
    public JsonResult<User> user_info(HttpSession session){

        //根据session获取uid
        User user = (User) session.getAttribute("user");

        User findUser = userService.findUserByUid(user.getUid());

        return new JsonResult<User>(findUser,"用户信息获取成功");
    }

    /**
     * 修改用户资料信息
     * @param user 由前端传递过来的phone、email、gender等信息包装成User对象
     * @param session 直接在Session中获取 uid和username等信息
     * @return 返回响应的状态码和更改过后的user信息-是否将更改后的user存储到session中？？？
     */
    @RequestMapping("/user/change_info")
    public JsonResult<User> change_Info(User user , HttpSession session){

        //进行用户资料的修改
        User changeInfo_user = userService.changeUserInfo(user,session);

        //将user信息存储到session中
        if (changeInfo_user != null){
            session.setAttribute("user",changeInfo_user);
        }

        //返回响应码和数据人
        return new JsonResult<User>(changeInfo_user,"用户资料修改成功");
    }


}
