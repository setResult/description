package org.aomr.desc.exception;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.aomr.desc.controller
 * Author:      aomr
 * Date:        2019/3/5 下午3:03
 * Description:
 */
public class ErrCodeException extends RuntimeException {
    public ErrCodeException() {
        super();
    }

    public ErrCodeException(String message) {
        super(message);
    }

    public ErrCodeException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ErrCodeException(String message, String code) {
        super(message);
        errcode = code;
    }

    public ErrCodeException(String message, String code, Throwable throwable) {
        super(message, throwable);
        errcode = code;
    }

    public ErrCodeException(String message, Throwable throwable, String code) {
        super(message, throwable);
        errcode = code;
    }

    public ErrCodeException(String message, Integer code) {
        super(message);
        errcode = code.toString();
    }

    public ErrCodeException(String message, Integer code, Throwable throwable) {
        super(message, throwable);
        errcode = code.toString();
    }

    public ErrCodeException(String message, Throwable throwable, Integer code) {
        super(message, throwable);
        errcode = code.toString();
    }

    ErrCodeException(Integer code, String message) {
        super(message);
        errcode = code.toString();
    }

    public ErrCodeException(Integer code) {
        super();
        errcode = code.toString();
    }

    private String errcode = "1001";

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode.toString();
    }
}
