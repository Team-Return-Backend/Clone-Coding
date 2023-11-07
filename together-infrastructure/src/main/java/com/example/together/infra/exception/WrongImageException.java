package com.example.together.infra.exception;


import com.example.common.error.BusinessException;
import com.example.common.error.ErrorCode;

public class WrongImageException extends BusinessException {

    public static final BusinessException EXCEPTION = new WrongImageException();
    private WrongImageException() { super(ErrorCode.WRONG_IMAGE);}
}
