package com.example.jushi.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 居無何
 * date: 2022/3/3 19:57
 * Description:
 */
public class Session {

    public static HttpSession getSession(){
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.
                        getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();//创建session对象
        return session;
    }

}
