package com.example.together.domain.user.presentation.dto.request;

import com.example.domain.user.dto.LoginRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginWebRequest {

    private String email;

    private String password;

    public LoginRequest toDomainRequest() {
        return LoginRequest.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }
}
