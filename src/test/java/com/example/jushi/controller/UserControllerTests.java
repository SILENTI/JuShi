package com.example.jushi.controller;

import com.example.jushi.model.User;
import com.example.jushi.util.JsonResult;
import com.example.jushi.util.Session;
import com.example.jushi.vo.UserVo;
import jdk.jfr.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * @author 居無何
 * date: 2022/2/23 17:48
 * Description: UserController测试单元
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTests {

        @Autowired
        private UserController userController;

    /**
     * 用户注册
     */
    @Test
        public void userRegister(){
            User user = new User();
            user.setUsername("梁朝伟");
            user.setPassword("0000");
            JsonResult josnDesign = userController.userRegister(user);
            System.out.println(josnDesign.toString());
        }

    /**
     * 用户登录
     */
    @Test
        public void userLogin () {
        User user = new User();
        user.setUsername("鲁路修");
        user.setPassword("5288");
        JsonResult findUser = userController.userLogin( new MockHttpSession(),user);
        System.out.println(findUser.toString());
    }

    /**
     * 用户密码修改
     */
    @Test
    public void changePassword (){

        //常见色session对象
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.
                        getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();//创建session对象

        UserVo userVo = new UserVo();
        userVo.setUid(14);
        userVo.setUsername("鲁路修");
        session.setAttribute("user",userVo);

        JsonResult jsonResult = userController.changePassword("8888","5288",session);
        System.out.println(jsonResult.toString());
    }

    /**
     * 查询用户信息
     */
    @Test
    public void user_info (){
        //常见色session对象
        HttpSession session = Session.getSession();
        User user = new User();
        user.setUid(14);
        session.setAttribute("user",user);
        JsonResult<User> findUser = userController.user_info(session);
        System.out.println(findUser.toString());
    }

    /**
     * 修改用户资料信息
     */
    @Test
    public void change_Info () {
        HttpSession session = Session.getSession();
        User user = new User();
        user.setUid(14);
        user.setGender(0);
        session.setAttribute("user",user);
        JsonResult<User> jsonResult = userController.change_Info(user,session);
        System.out.println(jsonResult.toString());
    }

    /**
     * 修改用户头像
     */
    @Test
    public void changeAvatar () throws FileNotFoundException {
        User user = new User();
        user.setUid(14);
        user.setUsername("鲁路修");
        HttpSession session = Session.getSession();
        session.setAttribute("user",user);
    }

}