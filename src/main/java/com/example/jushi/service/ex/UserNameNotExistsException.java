package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/2/25 16:48
 * Description: 用户名不存在
 */
public class UserNameNotExistsException extends ServiceException{

    public UserNameNotExistsException() {
        super();
    }

    public UserNameNotExistsException(String message) {
        super(message);
    }

    public UserNameNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameNotExistsException(Throwable cause) {
        super(cause);
    }

    protected UserNameNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
