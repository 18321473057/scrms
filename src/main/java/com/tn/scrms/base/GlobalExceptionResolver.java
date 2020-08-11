package com.tn.scrms.base;

import com.tn.scrms.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局Controller层异常处理类
 */
@ControllerAdvice
public class GlobalExceptionResolver extends BasicController {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Response handleException(Exception e) {
        logger.error("系统异常,msg = {} ,e={}", e.getMessage(), e);
        return returnFailure("系统异常,请刷新后再试或联系管理员!");
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Response handleOpdRuntimeException(BusinessException e) {
        logger.error("自定义异常,msg = {} ", e.getMessage());
        return returnFailure(e.getMessage());
    }
}
