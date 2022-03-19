package com.example.jushi.config;

import com.example.jushi.intercept.UserIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;

/**
 * @author 居無何
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 静态资源，配置静态资源目录
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/jushi/**").addResourceLocations("classpath:static/**");
    }

    /**
     * 实现页面跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/jushi/user/login_register").setViewName("login_register");
    }


    /**
     * 拦截器说明：
     *
     * WebMvcConfigurer.super.addInterceptors(registry);
     * addInterceptor：将自定义的拦截器注入适配器中。
     * addPathPatterns：设置所需拦截的路径。
     * excludePathPatterns：配置不需要拦截的路径。
     * */

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //拦截的请求-修改密码的请求拦截
        ArrayList <String> intercept = new ArrayList<>();
        intercept.add("/jushi/user/change_password");

        //放行的请求-统一将请求小写化
        ArrayList <String> exclude = new ArrayList<>();
        //放行所有的请求
        exclude.add("/**");
//        exclude.add("/jushi/user/login");
//        exclude.add("/jushi/user/register");
//        exclude.add("/jushi/user/login_register");
//
//        //放行的静态资源请求
//        exclude.add("/**/*.html");
//        exclude.add("/**/*.js");
//        exclude.add("/**/*.css");
//        exclude.add("/imgs/*.*");
//        exclude.add("/static/");
        //添加用户模块的拦截器
        registry.addInterceptor(new UserIntercept()).addPathPatterns(intercept).excludePathPatterns(exclude);
    }

    /**
     * 配置请求的url忽略大小写
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        //配置url访问大小写不敏感
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }
}
