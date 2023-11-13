package com.example.domain.user.usecase;

import com.example.common.annotation.UseCase;
import com.example.common.spi.SecurityPort;
import com.example.domain.user.dto.MyInfoResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class MyInfoUseCase {

    private final SecurityPort securityPort;

    public MyInfoResponse execute() {
        return MyInfoResponse.of(securityPort.getCurrentUser());
    }

}
