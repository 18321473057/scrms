package com.tn.scrms.exception;

import java.io.Serializable;

/**
 * @Author: yangcs
 * @Date: 2020/4/14 15:43
 * @Description: 自定义业务异常
 */
public class BusinessException extends RuntimeException implements Serializable {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException() {

    }
}
