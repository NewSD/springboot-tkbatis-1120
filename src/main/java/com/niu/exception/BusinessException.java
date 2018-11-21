package com.niu.exception;

import com.niu.enumtype.ReturnStatus;
import lombok.Data;

/**
 * Created by ami on 2018/11/20.
 */
@Data
public class BusinessException extends RuntimeException{
    private int errorCode;

    public BusinessException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }


    public BusinessException(ReturnStatus returnStatus) {
        super(returnStatus.getDesc());
        this.errorCode = returnStatus.getCode();
    }
}
