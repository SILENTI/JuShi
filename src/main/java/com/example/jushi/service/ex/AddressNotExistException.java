package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/6 10:42
 * Description: 查询的用户收货地址不存在
 */
public class AddressNotExistException extends ServiceException {
    public AddressNotExistException() {
        super();
    }

    public AddressNotExistException(String message) {
        super(message);
    }

    public AddressNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotExistException(Throwable cause) {
        super(cause);
    }

    protected AddressNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
