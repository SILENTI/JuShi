package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/5 16:43
 * Description: 用户所存储的地址已超出范围
 */
public class AddressOutOfRangeException extends ServiceException {

    public AddressOutOfRangeException() {
        super();
    }

    public AddressOutOfRangeException(String message) {
        super(message);
    }

    public AddressOutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressOutOfRangeException(Throwable cause) {
        super(cause);
    }

    protected AddressOutOfRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
