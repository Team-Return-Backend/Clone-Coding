package com.example.domain.user.exception;


import com.example.common.error.BusinessException;
import com.example.common.error.ErrorCode;

public class UserAlreadyExistException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserAlreadyExistException();
    private UserAlreadyExistException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }

}