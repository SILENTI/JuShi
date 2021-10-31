package com.example.jushi.mapper;

import com.example.jushi.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 居無何
 */
@Mapper
public interface UserMapper {

    /**
     * 根据id查询到用户信息
     * @param id
     * @return User
     * */
    User selectByPrimaryKey(Integer id);

    /**
     * 根据用户名和用户密码，查询用户信息
     * @param userName 用户名
     * @param passWord 登录密码
     * @return User 返回查询到的用户信息
     */
    User selectForUser (@Param("userName") String userName , @Param("passWord") String passWord );

//    int deleteByPrimaryKey(Integer id);
//
//    int insert(User record);
//
//    List<User> selectAll();
//
//    int updateByPrimaryKey(User record);

}