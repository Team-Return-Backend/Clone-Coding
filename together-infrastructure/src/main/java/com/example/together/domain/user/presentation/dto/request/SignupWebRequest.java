package com.example.together.domain.user.presentation.dto.request;

import com.example.domain.user.dto.SignupRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class SignupWebRequest {

    @NotNull
    private String nickname;

    @NotNull
    private String password;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    public SignupRequest toDomainRequest() {
        return SignupRequest.builder()
                .nickname(this.nickname)
                .password(this.password)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .build();
    }
}