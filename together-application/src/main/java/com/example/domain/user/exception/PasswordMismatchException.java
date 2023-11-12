package com.example.domain.user.exception;


import com.example.common.error.BusinessException;
import com.example.common.error.ErrorCode;

public class PasswordMismatchException extends BusinessException {
    public static final BusinessException EXCEPTION = new PasswordMismatchException();
    private PasswordMismatchException(){
        super (ErrorCode.PASSWORD_MISMATCH);
    }
}