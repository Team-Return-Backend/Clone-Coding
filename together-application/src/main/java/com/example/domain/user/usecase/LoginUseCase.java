package com.example.domain.user.usecase;

import com.example.common.annotation.UseCase;
import com.example.domain.auth.dto.TokenResponse;
import com.example.domain.user.dto.LoginRequest;
import com.example.domain.user.exception.PasswordMismatchException;
import com.example.domain.user.exception.UserAlreadyExistException;
import com.example.domain.user.exception.UserNotFoundException;
import com.example.domain.user.model.User;
import com.example.domain.user.spi.QueryUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class LoginUseCase {

    private final QueryUserPort queryUserPort;

    public TokenResponse execute(LoginRequest request) {

        User user = queryUserPort.queryUserByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (user.getPassword()!= request.getPassword()){
            throw PasswordMismatchException.EXCEPTION;
        }

        if (queryUserPort.existsUserByEmail(request.getEmail())) {
            throw UserAlreadyExistException.EXCEPTION;
        }
        
        return TokenResponse.builder().build();
    }
}

