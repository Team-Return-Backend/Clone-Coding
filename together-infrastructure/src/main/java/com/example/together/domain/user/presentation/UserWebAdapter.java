package com.example.together.domain.user.presentation;

import com.example.domain.auth.dto.TokenResponse;
import com.example.domain.user.dto.MyInfoResponse;
import com.example.domain.user.usecase.LoginUseCase;
import com.example.domain.user.usecase.MyInfoUseCase;
import com.example.domain.user.usecase.SignupUseCase;
import com.example.together.domain.user.presentation.dto.request.LoginWebRequest;
import com.example.together.domain.user.presentation.dto.request.SignupWebRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserWebAdapter {

    private final LoginUseCase loginUseCase;
    private final SignupUseCase signupUseCase;
    private final MyInfoUseCase myInfoUseCase;

    @PostMapping("/signup")
    public TokenResponse signup(@RequestBody @Valid SignupWebRequest webRequest) {
        return signupUseCase.execute(webRequest.toDomainRequest());
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginWebRequest webRequest) {
        return loginUseCase.execute(webRequest.toDomainRequest());
    }

    @GetMapping
    public MyInfoResponse myInfo() {
        return myInfoUseCase.execute();
    }
}
