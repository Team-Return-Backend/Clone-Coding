package com.example.domain.auth.spi;

import com.example.domain.auth.dto.TokenResponse;

public interface JwtPort {

    TokenResponse createToken(String email);
}
