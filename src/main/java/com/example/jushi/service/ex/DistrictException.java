package com.example.jushi.service.ex;

/**
 * @author 居無何
 * date: 2022/3/6 19:34
 * Description: 查询地区信息是遇到未知问题
 */
public class DistrictException extends ServiceException {

    public DistrictException() {
        super();
    }

    public DistrictException(String message) {
        super(message);
    }

    public DistrictException(String message, Throwable cause) {
        super(message, cause);
    }

    public DistrictException(Throwable cause) {
        super(cause);
    }

    protected DistrictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
