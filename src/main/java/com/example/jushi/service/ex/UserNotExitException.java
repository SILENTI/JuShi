package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/3 10:19
 * Description: 用户不存在所抛出的异常
 */
public class UserNotExitException extends ServiceException{
    public UserNotExitException() {
        super();
    }

    public UserNotExitException(String message) {
        super(message);
    }

    public UserNotExitException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotExitException(Throwable cause) {
        super(cause);
    }

    protected UserNotExitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
