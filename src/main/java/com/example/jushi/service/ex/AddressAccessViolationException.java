package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/8 15:26
 * Description: 非法访问
 */
public class AddressAccessViolationException extends ServiceException{
    public AddressAccessViolationException() {
        super();
    }

    public AddressAccessViolationException(String message) {
        super(message);
    }

    public AddressAccessViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressAccessViolationException(Throwable cause) {
        super(cause);
    }

    protected AddressAccessViolationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
