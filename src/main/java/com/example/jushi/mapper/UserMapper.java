package com.example.jushi.mapper;

import com.example.jushi.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 根据传递进入的User实体对象，添加user记录，返回的Integer确认是否添加成功
     * @param user
     * @return 返回变化的行数，也确认是否修改成功
     */
    Integer insert(User user);

    /**
     * 更用户名查询用户详细信息
     * @param UserName
     * @return 返回user对象
     */
    User findUserName(String UserName);

    /**
     * 根据传递的username和password，查询表中是否含有该信息
     * @param userName
     * @param passWord
     * @return 返回的User实体对象，确认是否含有该记录
     */
    User selectUser (String userName, String passWord);

    /**
     * 根据uid，查询用户信息
     * @param uid
     * @return 返回查询到的User实体对象，若uid无效则查询到的user为null
     */
    User findUserByPrimaryKey (Integer uid);

    /**
     * 根据传递的user信息，进行更新记录，更新数据有 Password 密码 ，modifUser 记录修改人 ， modifTime 记录修改时间
     * @param uid
     * @param password
     * @param modifUser
     * @param modifTime
     * @return 若数据更新成功，返回更新的行数
     */
    Integer updatePassword (Integer uid , String password, String modifUser , Date modifTime);

    /**
     * 修改用户信息，通过传递User对象，其包括电话 phone、邮箱 email、性别 gender、修改人 modifUser、修改时间、modifTime 修改时间；
     * @param user
     * @return 返回修改的行数
     */
    Integer updateUserInfoByPrimaryKey(User user);

    /**
     * 更新用户头像
     * @param user
     * @return
     */
    Integer updateUserAvatar (User user);

    int deleteByPrimaryKey(Integer uid);

    User selectByPrimaryKey(Integer uid);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}