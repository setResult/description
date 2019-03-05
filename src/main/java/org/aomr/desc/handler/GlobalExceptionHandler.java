package org.aomr.desc.handler;

import org.aomr.desc.dto.Result;
import org.aomr.desc.exception.ErrCodeException;
import org.aomr.desc.exception.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Result argumentHandler(MethodArgumentTypeMismatchException e) {
        logger.error("参数类型匹配错误: ", e);
        return new Result<>(ErrorCodeEnum.ARGUEMENT_ERROR, e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Result httpMessageNotReadableHandler(HttpMessageNotReadableException e) {
        logger.error("请求参数无法读取: ", e);
        return new Result<>(ErrorCodeEnum.HTTP_MESSAGE_NOT_READABLE, e.getHttpInputMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result methodArgumentNotValid(MethodArgumentNotValidException e) {
        logger.error("请求参数校验出错: ", e);
        return new Result<>(ErrorCodeEnum.ARGUMENT_VALID_ERROR, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        logger.error("请求方式出错: ", e);
        return new Result<>(ErrorCodeEnum.HTTP_REQUEST_METHOD_NOT_SUPPORTED, e.getMessage());
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseBody
    public Result signFailed(IllegalArgumentException e) {
        logger.error("非法参数: ", e);
        return new Result<>(ErrorCodeEnum.ARGUMENT_VALID_ERROR, e.getMessage());
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    @ResponseBody
    public Result missingParameter(MissingServletRequestParameterException e) {
        logger.error("参数缺失: ", e);
        return new Result<>(ErrorCodeEnum.MISSING_REQUEST_PARAMETER, e.getMessage());
    }


    @ExceptionHandler(value = {ErrCodeException.class})
    @ResponseBody
    public Result errorEnum(ErrCodeException e) {
        logger.error("手动异常抛出: ", e);
        return new Result<>(e);
    }

}
