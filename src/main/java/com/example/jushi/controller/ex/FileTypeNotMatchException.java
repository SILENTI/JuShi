package com.example.jushi.controller.ex;

/**
 * @author 居無何
 * date: 2022/3/4 15:31
 * Description: 上传的文件类型不匹配
 */
public class FileTypeNotMatchException extends FileUploadException {
    public FileTypeNotMatchException() {
        super();
    }

    public FileTypeNotMatchException(String message) {
        super(message);
    }

    public FileTypeNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeNotMatchException(Throwable cause) {
        super(cause);
    }

    protected FileTypeNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
