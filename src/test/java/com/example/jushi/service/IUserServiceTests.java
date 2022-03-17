package com.example.jushi.service;

import com.example.jushi.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 居無何
 * date: 2022/2/23 19:43
 * Description: 用户service服务层单元测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserServiceTests {

    @Autowired
    private IUserService IUserService;

    /**
     * 用户注册Service-TEST
     */
    @Test
    public void insertUser (){
       User user = new User();
       user.setUsername("鲁路修");
       user.setPassword("5288");
       IUserService.insertUser(user);
    }

    /**
     * 用户登录Service-TEST
     */
    @Test
    public void userLogin () {
        User user = new User();
        user.setUsername("鲁路修");
        user.setPassword("5288");
        User judge = IUserService.userLogin(user);
        if (judge != null){
            System.out.println(judge.toString());
            System.out.println("----登录成功---");
        }
    }

    /**
     * 用户密码修改-service层
     */
    @Test
    public void changePassword () {
        IUserService.changePassword(14,"居無何","5288","8888");
    }

    /**
     * 修改用户资料信息
     */
    @Test
    public void changeUserInfo () {
        //常见色session对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
        User user = new User();
        user.setUid(14);
        user.setUsername("鲁路修");
        user.setPassword("8888");
        user.setPhone("1234567890");
        user.setEmail("1234567890@qq.com");
        session.setAttribute("user",user);

        User user1 = IUserService.changeUserInfo(user,session);
        System.out.println(user1.toString());
    }

}
