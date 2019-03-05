package org.aomr.desc.handler;

import org.aomr.desc.dto.Result;
import org.aomr.desc.exception.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalEscapeExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalEscapeExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        logger.error("接口请求Handler映射失败或方法内执行错误: ", e);
        return new Result<>(ErrorCodeEnum.FAIL, e.getMessage());
    }
}
