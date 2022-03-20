package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/20 16:11
 * Description:
 */
public class GoodsSoldOutException extends ServiceException{

    public GoodsSoldOutException() {
        super();
    }

    public GoodsSoldOutException(String message) {
        super(message);
    }

    public GoodsSoldOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodsSoldOutException(Throwable cause) {
        super(cause);
    }

    protected GoodsSoldOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
