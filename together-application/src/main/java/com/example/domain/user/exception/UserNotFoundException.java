package com.example.domain.user.exception;


import com.example.common.error.BusinessException;
import com.example.common.error.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotFoundException();
    private UserNotFoundException(){
        super (ErrorCode.USER_NOT_FOUND);
    }
}