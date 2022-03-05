package com.example.jushi.mapper;

import com.example.jushi.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author 居無何
 * date: 2022/2/22 12:30
 * Description:userMapper的单元测试类
 */
/**
 * 1. 方法必须被@TEST修饰
 * 2. 返回值应是void
 * 3. 方法参数内无任何类型
 * 4. 方法的修饰权限必须是public
 */
@SpringBootTest
//标明这是一个springboot测试类，该类不会跟随项目打包
@RunWith(SpringRunner.class)
//标明这是单元测试类
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户记录
     */
    @Test
    public void insert (){
        User user = new User();
        user.setUsername("梁朝伟");
        user.setPassword("5288");
        Integer num = userMapper.insert(user);
        System.out.println("新增行数："+ num);
    }

    /**
     * 根据用户名和密码，查询用户记录
     */
    @Test
    public void selectUser (){
        User user = userMapper.selectUser("梁朝伟","5288");
        System.out.println(user.toString());

    }

    /**
     * 验证用户名是否被占用
     */
    @Test
    public void findUserName (){
        User user = userMapper.findUserName("鲁路修");
        if (user != null){
            System.out.println(user.toString());
        }else {
            System.out.println("未含有该用户名");
        }
    }

    /**
     * 根据uid查询用户得到详细信息
     */
    @Test
    public void findUserByPrimaryKey (){
        User user = userMapper.findUserByPrimaryKey(1);
        System.out.println(user.toString());
    }

    /**
     * 修改用户密码
     */
    @Test
    public void updatePassword () {
        User user = new User();
        user.setUid(1);
        user.setPassword("5288");
        user.setModifUser("居無何");
        user.setModifTime(new Date());
        Integer index = userMapper.updatePassword(user.getUid(),user.getPassword(),user.getModifUser(),user.getModifTime());
        System.out.println("成功修改记录数："+ index);
    }

    /**
     * 修改用户信息资料
     */
    @Test
    public void updateUserInfo (){

    }

    /**
     * 修改用户头像
     */
    @Test
    public void updateUserAvatar () {
        User user = new User();
        user.setUid(14);
        user.setAvatar("头像路径");
        user.setModifUser("鲁路修");
        user.setModifTime(new Date());
        Integer record  = userMapper.updateUserAvatar(user);
        System.out.println("修改记录："+ record);
    }
}
