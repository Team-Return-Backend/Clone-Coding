package com.example.together.global.exception;


import com.example.common.error.BusinessException;
import com.example.common.error.ErrorCode;

public class InvalidTokenException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidTokenException();
    private InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);

    }
}
