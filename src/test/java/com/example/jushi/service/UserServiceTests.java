package com.example.jushi.service;

import com.example.jushi.model.User;
import com.example.jushi.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 居無何
 * date: 2022/2/23 19:43
 * Description: 用户service服务层单元测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    /**
     * 用户注册Service-TEST
     */
    @Test
    public void insertUser (){
       User user = new User();
       user.setUsername("鲁路修");
       user.setPassword("5288");
       userService.insertUser(user);
    }

    /**
     * 用户登录Service-TEST
     */
    @Test
    public void userLogin () {
        User user = new User();
        user.setUsername("鲁路修");
        user.setPassword("5288");
        UserVo judge = userService.userLogin(user);
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
        userService.changePassword(14,"居無何","5288","8888");
    }

}
