package com.example.jushi.controller;

import com.example.jushi.model.User;
import com.example.jushi.util.JsonResult;
import com.example.jushi.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;


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
}