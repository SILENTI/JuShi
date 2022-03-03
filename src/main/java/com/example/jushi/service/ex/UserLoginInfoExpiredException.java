package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/3 11:05
 * Description: 用户登录信息过期
 */
public class UserLoginInfoExpiredException extends ServiceException{

    public UserLoginInfoExpiredException() {
        super();
    }

    public UserLoginInfoExpiredException(String message) {
        super(message);
    }

    public UserLoginInfoExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginInfoExpiredException(Throwable cause) {
        super(cause);
    }

    protected UserLoginInfoExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
