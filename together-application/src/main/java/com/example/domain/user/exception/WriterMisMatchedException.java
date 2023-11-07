package com.example.domain.user.exception;

import com.example.common.error.BusinessException;
import com.example.common.error.ErrorCode;

public class WriterMisMatchedException extends BusinessException {
    public static final BusinessException EXCEPTION = new WriterMisMatchedException();
    private WriterMisMatchedException(){
        super(ErrorCode.WRITER_MISMATCH);
    }
}
