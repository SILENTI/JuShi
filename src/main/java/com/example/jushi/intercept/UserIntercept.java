package com.example.jushi.intercept;

import com.example.jushi.vo.UserVo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 居無何
 * date: 2022/2/27 19:12
 * Description: 用户模块拦截器-拦截用户密码修改
 */
public class UserIntercept implements HandlerInterceptor {

    /**
     * 正向执行，在请求之前调用即在controller 请求渲染前执行该方法
     * @param request 发送的请求及携带的信息
     * @param response 返回的请求及发送到view层所携带的信息
     * @param handler 传递消息
     * @return 返回Boolean值，表示是否放过该请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle执行---");
        System.out.println(request.getServletPath());

        //通过 preHandle 拦截器，判断存储Session中user是否生效（就是是否存储），来决定是否放行通过
        UserVo userVo = (UserVo) request.getSession().getAttribute("user");

        //用户密码修改请求拦截-即当条件满足 url为 /jushi/user/change_password" 并且存储在session中的user为空，则将页面跳转到登录页面
        if ( request.getServletPath().equals("/jushi/user/change_password") && userVo == null){
            System.out.println("更改密码！！！！！");
            response.sendRedirect("/jushi/user/login_register");
            // 若条件不符合，进入登录页面
            return false;
        }

        return true;
    }

    /**
     * 逆向执行。需要所有的preHandle都返回true时才会调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle执行----");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 在所有请求和静态资源处理好后，执行该方法
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion执行----");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
