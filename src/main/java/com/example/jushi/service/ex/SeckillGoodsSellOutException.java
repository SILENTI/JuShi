package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/19 16:01
 * Description:
 */
public class SeckillGoodsSellOutException extends ServiceException{

    public SeckillGoodsSellOutException() {
        super();
    }

    public SeckillGoodsSellOutException(String message) {
        super(message);
    }

    public SeckillGoodsSellOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillGoodsSellOutException(Throwable cause) {
        super(cause);
    }

    protected SeckillGoodsSellOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
