package com.example.jushi.controller;

import com.example.jushi.controller.ex.FileEmptyException;
import com.example.jushi.controller.ex.FileRedWriteException;
import com.example.jushi.controller.ex.FileSizeOutException;
import com.example.jushi.controller.ex.FileTypeNotMatchException;
import com.example.jushi.model.User;
import com.example.jushi.service.UserService;
import com.example.jushi.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

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
    @RequestMapping(value = "/user_info",method = RequestMethod.GET)
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
    @RequestMapping(value = "/change_info",method = RequestMethod.POST)
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

    /**
     * 上传的图片文件的最大限制
     */
    public static final Integer Avatar_Max_Size = 10 * 1024 * 1024;

    /**
     * 符合的上传文件类型
     */
    public static ArrayList<String> FileTypes = new ArrayList<>();

    /**
     * 静态块文件类型
     */
    static{
           FileTypes.add("image/png");
           FileTypes.add("image/jpg");
    }

    /**
     * 修改用户头像
     * @param session
     * @param multipartFile
     * @return 返回响应码
     */
    @RequestMapping(value = "/change_avatar",method = RequestMethod.POST)
    public JsonResult<Void> change_avatar (HttpSession session, @RequestParam("avatarFile") MultipartFile multipartFile){

        //对文件进行审核-文件是否为null、文件大小、文件类型；
        if (multipartFile.isEmpty()){
            throw new FileEmptyException("上传文件为空");
        } else if (multipartFile.getSize() > Avatar_Max_Size){
            throw new FileSizeOutException("上传文件超出限制");
        } else if (!FileTypes.contains(multipartFile.getContentType())){
            throw new FileTypeNotMatchException("文件类型不符");
        }

        //先将头像图片文件传递到服务器存储-现直接上文件上传到static文件夹现的imgs文件夹现的user文件夹
        String multipartFileType = multipartFile.getContentType();
        String fileType = multipartFileType.substring(multipartFileType.lastIndexOf("/")+1);
        String fileName = UUID.randomUUID().toString()+"."+fileType;
        String filePath = "E:\\PRPJECT\\JavaEE\\JuShi\\src\\main\\resources\\static\\imgs\\"+fileName;
        File file = new File(filePath);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new FileRedWriteException("文件读写时出现未知无误");
        }

        //获取存储在服务器中的图片的路径
        String avatarPath = filePath.substring(filePath.lastIndexOf("static\\"));

        //将路径和session中存储的user信息传递个service层做数据的更新
        User user = (User) session.getAttribute("user");
        System.out.println("session:"+user.toString());
        userService.changeAvatar(user.getUid(),avatarPath,user.getUsername());

        //若都未抛出异常，返回响应码 200
        return new JsonResult<Void>("用户头像上传成功");
    }

}
