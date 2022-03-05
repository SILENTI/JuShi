package com.example.jushi.controller.ex;

/**
 * @author 居無何
 * date: 2022/3/4 15:30
 * Description: 上传文件大小超出限制
 */
public class FileSizeOutException extends FileUploadException{
    public FileSizeOutException() {
        super();
    }

    public FileSizeOutException(String message) {
        super(message);
    }

    public FileSizeOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeOutException(Throwable cause) {
        super(cause);
    }

    protected FileSizeOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
