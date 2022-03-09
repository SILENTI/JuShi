package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/9 17:35
 * Description:
 */
public class DeleteException extends ServiceException{
    public DeleteException() {
        super();
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    protected DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
