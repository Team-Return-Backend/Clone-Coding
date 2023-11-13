package com.example.domain.user.usecase;

import com.example.common.annotation.UseCase;
import com.example.domain.auth.dto.TokenResponse;
import com.example.domain.auth.spi.JwtPort;
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
    private final JwtPort jwtPort;

    public TokenResponse execute(LoginRequest request) {

        User user = queryUserPort.queryUserByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!request.getPassword().equals(user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtPort.createToken(user.getEmail());
    }
}


