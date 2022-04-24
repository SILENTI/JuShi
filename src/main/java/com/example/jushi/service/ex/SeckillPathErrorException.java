package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/4/24 15:55
 * Description:
 */
public class SeckillPathErrorException extends ServiceException {
    public SeckillPathErrorException() {
        super();
    }

    public SeckillPathErrorException(String message) {
        super(message);
    }

    public SeckillPathErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillPathErrorException(Throwable cause) {
        super(cause);
    }

    protected SeckillPathErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
