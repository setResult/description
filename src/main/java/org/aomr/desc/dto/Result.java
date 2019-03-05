package org.aomr.desc.dto;


import org.aomr.desc.exception.ErrCodeException;
import org.aomr.desc.exception.ErrorCodeEnum;
import org.aomr.desc.util.time.DateTimeUtil;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.aomr.desc.controller
 * Author:      aomr
 * Date:        2019/3/5 下午3:03
 * Description: 返回结果类
 */
public class Result<D> {

    private Integer errno;

    private String errmsg;

    private String timestamp;

    private D data;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public Result() {
        this.errno = ErrorCodeEnum.SUCCESS.getErrorNo();
        this.errmsg = ErrorCodeEnum.SUCCESS.getErrorMsg();
        this.data = null;
        this.timestamp = DateTimeUtil.getNowDateTime().toString();
    }

    public Result(D d) {
        this.errno = ErrorCodeEnum.SUCCESS.getErrorNo();
        this.errmsg = ErrorCodeEnum.SUCCESS.getErrorMsg();
        this.data = d;
        this.timestamp = DateTimeUtil.getNowDateTime().toString();
    }

    public Result(ErrorCodeEnum errorCodeEnum) {
        this.errno = errorCodeEnum.getErrorNo();
        this.errmsg = errorCodeEnum.getErrorMsg();
        this.data = null;
        this.timestamp = DateTimeUtil.getNowDateTime().toString();
    }

    public Result(ErrorCodeEnum errorCodeEnum, D data) {
        this.errno = errorCodeEnum.getErrorNo();
        this.errmsg = errorCodeEnum.getErrorMsg();
        this.data = data;
        this.timestamp = DateTimeUtil.getNowDateTime().toString();
    }

    public Result(ErrCodeException exception) {
        this.errno = Integer.valueOf(exception.getErrcode());
        this.errmsg = exception.getMessage();
        this.data = null;
        this.timestamp = DateTimeUtil.getNowDateTime().toString();
    }
}
