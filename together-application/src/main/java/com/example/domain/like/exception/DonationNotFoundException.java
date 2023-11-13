package com.example.domain.like.exception;


import com.example.common.error.BusinessException;
import com.example.common.error.ErrorCode;

public class DonationNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new DonationNotFoundException();
    private DonationNotFoundException(){
        super (ErrorCode.USER_NOT_FOUND);
    }
}