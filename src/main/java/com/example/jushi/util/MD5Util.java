package com.example.jushi.util;

import org.springframework.data.redis.core.script.DigestUtils;
import java.util.UUID;

/**
 * @author 居無何
 * date: 2022/2/22 19:21
 * Description: MD5密码加密
 */
public class MD5Util {

    /**
     * 获取盐值
     * @return 返回生成的颜值
     */
    public static String getSalt () {
        String salt = UUID.randomUUID().toString();
        return salt;
    }

    /**
     * 简单的MD5加密
     * 根据获取的密码和盐值进行加密
     * @param pwd
     * @return 返回加密后的密码
     */
    public static String MD5 (String pwd , String salt){
        return DigestUtils.sha1DigestAsHex(pwd+salt);
    }

}
