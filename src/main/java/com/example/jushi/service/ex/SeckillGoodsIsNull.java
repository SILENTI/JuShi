package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/4/21 13:41
 * Description:
 */
public class SeckillGoodsIsNull extends ServiceException{

    public SeckillGoodsIsNull() {
        super();
    }

    public SeckillGoodsIsNull(String message) {
        super(message);
    }

    public SeckillGoodsIsNull(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillGoodsIsNull(Throwable cause) {
        super(cause);
    }

    protected SeckillGoodsIsNull(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
