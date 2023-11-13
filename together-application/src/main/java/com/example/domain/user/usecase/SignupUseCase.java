package com.example.domain.user.usecase;

import com.example.common.annotation.UseCase;
import com.example.domain.auth.dto.TokenResponse;
import com.example.domain.auth.spi.JwtPort;
import com.example.domain.user.dto.LoginRequest;
import com.example.domain.user.dto.SignupRequest;
import com.example.domain.user.exception.PasswordMismatchException;
import com.example.domain.user.exception.UserAlreadyExistException;
import com.example.domain.user.exception.UserNotFoundException;
import com.example.domain.user.model.User;
import com.example.domain.user.spi.CommandUserPort;
import com.example.domain.user.spi.QueryUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SignupUseCase {

    private final CommandUserPort commandUserPort;
    private final QueryUserPort queryUserPort;
    private final JwtPort jwtPort;

    public TokenResponse execute(SignupRequest request) {

        if (queryUserPort.existsUserByEmail(request.getEmail())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        User user = commandUserPort.saveUser(
                User.builder()
                        .nickname(request.getNickname())
                        .password(request.getPassword())
                        .phoneNumber(request.getPhoneNumber())
                        .email(request.getEmail())
                        .build()
        );

        return jwtPort.createToken
                (user.getEmail());
    }
}


