package com.example.together.domain.user.presentation;

import com.example.domain.auth.dto.TokenResponse;
import com.example.domain.user.usecase.LoginUseCase;
import com.example.together.domain.user.presentation.dto.request.LoginWebRequest;
import com.example.together.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserWebAdapter {

    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginWebRequest webRequest) {
        return loginUseCase.execute(webRequest.toDomainRequest());
    }
}
