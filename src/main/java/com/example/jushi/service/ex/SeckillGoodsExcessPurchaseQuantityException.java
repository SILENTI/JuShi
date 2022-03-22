package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/21 13:13
 * Description:
 */
public class SeckillGoodsExcessPurchaseQuantityException extends ServiceException {

    public SeckillGoodsExcessPurchaseQuantityException() {
        super();
    }

    public SeckillGoodsExcessPurchaseQuantityException(String message) {
        super(message);
    }

    public SeckillGoodsExcessPurchaseQuantityException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillGoodsExcessPurchaseQuantityException(Throwable cause) {
        super(cause);
    }

    protected SeckillGoodsExcessPurchaseQuantityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
