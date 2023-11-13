package com.example.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupRequest {

    private String nickname;

    private String password;

    private String phoneNumber;

    private String email;

}
