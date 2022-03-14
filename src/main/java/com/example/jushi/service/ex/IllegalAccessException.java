package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/13 22:13
 * Description: 非法访问
 */
public class IllegalAccessException extends ServiceException{

    public IllegalAccessException() {
        super();
    }

    public IllegalAccessException(String message) {
        super(message);
    }

    public IllegalAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAccessException(Throwable cause) {
        super(cause);
    }

    protected IllegalAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
