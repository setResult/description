package org.aomr.desc.exception;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.aomr.desc.controller
 * Author:      aomr
 * Date:        2019/3/5 下午5:45
 * Description: httpException
 */
public class HttpException extends ErrCodeException {
    public HttpException() {
        super(4005, "网络访问错误");
    }
}
