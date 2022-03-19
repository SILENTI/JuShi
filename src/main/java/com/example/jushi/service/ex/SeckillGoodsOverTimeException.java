package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/19 15:59
 * Description:
 */
public class SeckillGoodsOverTimeException extends ServiceException{
    public SeckillGoodsOverTimeException() {
        super();
    }

    public SeckillGoodsOverTimeException(String message) {
        super(message);
    }

    public SeckillGoodsOverTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillGoodsOverTimeException(Throwable cause) {
        super(cause);
    }

    protected SeckillGoodsOverTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
