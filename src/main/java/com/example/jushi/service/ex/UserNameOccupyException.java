package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/2/22 19:17
 * Description: 用户名被占用
 */
public class UserNameOccupyException extends ServiceException{
    public UserNameOccupyException() {
        super();
    }

    public UserNameOccupyException(String message) {
        super(message);
    }

    public UserNameOccupyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameOccupyException(Throwable cause) {
        super(cause);
    }

    protected UserNameOccupyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
