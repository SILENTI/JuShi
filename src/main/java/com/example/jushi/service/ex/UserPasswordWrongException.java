package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/2/25 16:45
 * Description: 用户密码错误
 */
public class UserPasswordWrongException extends ServiceException{
    public UserPasswordWrongException() {
        super();
    }

    public UserPasswordWrongException(String message) {
        super(message);
    }

    public UserPasswordWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserPasswordWrongException(Throwable cause) {
        super(cause);
    }

    protected UserPasswordWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
