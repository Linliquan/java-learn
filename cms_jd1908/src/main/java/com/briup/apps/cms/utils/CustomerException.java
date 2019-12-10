package com.briup.apps.cms.utils;

/**
 * @program: cms_jd1908
 * @description: 自定义异常
 * @author: liquan
 * @create: 2019-11-17 12:24
 **/
public class CustomerException extends RuntimeException {
    public CustomerException() {
    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerException(Throwable cause) {
        super(cause);
    }

    public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
