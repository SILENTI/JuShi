package com.example.jushi.controller.ex;

/**
 * @author 居無何
 * date: 2022/3/4 15:31
 * Description: 文件读写时异常
 */
public class FileRedWriteException extends FileUploadException {
    public FileRedWriteException() {
        super();
    }

    public FileRedWriteException(String message) {
        super(message);
    }

    public FileRedWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileRedWriteException(Throwable cause) {
        super(cause);
    }

    protected FileRedWriteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
