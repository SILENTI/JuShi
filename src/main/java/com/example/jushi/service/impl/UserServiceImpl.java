package com.example.jushi.service.impl;

import com.example.jushi.mapper.UserMapper;
import com.example.jushi.model.User;
import com.example.jushi.service.IUserService;
import com.example.jushi.service.ex.*;
import com.example.jushi.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * @author 居無何
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {

        //先根据用户名，查询底层数据库，确定用户名是否被占用，若被占用抛出异常
        User findUser = userMapper.findUserName(user.getUsername());
        if (findUser != null){
            throw new UserNameOccupyException("用户名已被占用");
        }

        //添加日志记录
        Date date = new Date();
        user.setCreateUser(user.getUsername());
        user.setCreateTime(date);
        user.setModifUser(user.getUsername());
        user.setModifTime(date);

        //将用户秘密，进行加密
        //使用该方式加密，会出现加密后的密码过长，出现异常
        String salt = MD5Util.getSalt();
        String pwd = MD5Util.MD5(user.getPassword(),salt);
        user.setSalt(salt);
        user.setPassword(pwd);

        //若用户名未被占用，添加用户记录,若遇到未知的问题出现用户记录添加失败，抛出异常
        Integer judge = userMapper.insert(user);
        if (judge != 1){
            throw new InsertException("遇到未知错误，记录添加错误");
        }

    }

    /**
     * 根据用户传递的user信息与查询到对的user信息进行比较
     * @param user
     * @return 信息符合，返回全信息user对象
     */
    @Override
    public User userLogin(User user) {

        User findUser = userMapper.findUserName(user.getUsername());

        //若查询到user为null
        if (findUser == null ){
            throw new UserNameNotExistsException("用户名不存在");
        }

        //比较查询到的User密码和传递过来的密码（将用户传递过来的密码后查询到的用户盐值进行加密，后比较）
        String password = MD5Util.MD5(user.getPassword(),findUser.getSalt());

        if (!password.equals(findUser.getPassword())){
            throw new UserNameOccupyException("账号密码错误");
        }

        //若未抛出以上异常，则证明条件符合，登录成功
        return findUser;
    }

//    /**
//    * 判断账号和密码是否正确
//    * */
//    @Override
//    public Boolean judegUser (String userName , String passWord , HttpSession session) {
//          User realUser = userMapper.selectUser(userName,passWord);
//          if (realUser!=null && realUser.getUsername().equals(userName )&& realUser.getPassword().equals(passWord)){
//              session.setAttribute("user",realUser);
//              return true;
//          }
//        return false;
//    }

    /**
     * 修改用户密码
     * @param uid
     * @param userName
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void changePassword(Integer uid, String userName, String oldPassword, String newPassword) {

        //更具uid查询到的user信息比对旧密码是否正确
        User findUser = userMapper.findUserByPrimaryKey(uid);

        //如果查询到的User不存在，在内部抛出异常
        if (findUser == null){
            throw new UserNameOccupyException("更具uid查询的user，不存在！");

        //将查询到的密码与输入的密码进行比较
        }else if (!findUser.getPassword().equals(MD5Util.MD5(oldPassword,findUser.getSalt()))){
            throw new UserPasswordWrongException("用户密码错误");
        }

        //若以上无任何问题，进行密码的修改
        //将新密码进行加密
        String encryptNewPassword = MD5Util.MD5(newPassword,findUser.getSalt());
        Integer record = userMapper.updatePassword(uid,encryptNewPassword,userName,new Date());

        //如果更新的记录为零，则证明用户密码修改遇到未知的问题，导致用户密码修改失败，抛出异常
        if (record == 0){
            throw new UpdateException("遇到未知错误，密码修改失败");
        }

    }

    /**
     * 根据uid查询到user信息
     * @param uid
     * @return
     */
    @Override
    public User findUserByUid(int uid) {
        User user = userMapper.findUserByPrimaryKey(uid);
        if (user == null){
            throw new UserNotExitException("当前用户不存在");
        }
        return user;
    }

    /**
     * 修改用户资料信息
     * @param user 有前端传递过来的所要修改的信息 phone,email,gender
     * @param session 从session中获取得到的User对象
     */
    @Override
    public User changeUserInfo(User user, HttpSession session) {

        //先检验Session中存储的user是否还生效
        User session_user = (User) session.getAttribute("user");
        if (session_user == null){
            throw new UserLoginInfoExpiredException("用户登录信息过期");
        }

        //查询用户是否存在
        User findUser = userMapper.findUserByPrimaryKey(session_user.getUid());
        if (findUser == null){
            throw new UserNotExitException("用户不存在");
        }

        //将session中的userVo中的信息存储到User中，传递给dao
        user.setUid(findUser.getUid());
        user.setUsername(findUser.getUsername());
        user.setModifUser(findUser.getUsername());
        user.setModifTime(new Date());

        //进行数据的修改
        Integer record = userMapper.updateUserInfoByPrimaryKey(user);
        if (record != 1){
            throw new UpdateException("用户资料修改出现未知错误");
        }

        //数据更新以后再次进行查询或返回组成的User信息
        User findNewUser = this.findUserByUid(findUser.getUid());
        return findNewUser;
    }

    /**
     * 修改用户头像
     * @param uid 用户uid
     * @param avatar 用户头像的地址路径
     * @param username 修改头像的用户名
     */
    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {

        //查询user是否生效
        findUserByUid(uid);

//        System.out.println(uid+"   "+username);

        //若用户存在，则进行用户头像的修改\
        User user = new User();
        user.setUid(uid);
        user.setAvatar(avatar);
        user.setUsername(username);
        Integer record =  userMapper.updateUserAvatar(user);

//        System.out.println("修改记录"+record);

        if (record != 1){
            throw new UpdateException("遇到未知错误,数据更新失败");
        }

    }
}
