package com.example.together.global.config;

import com.example.together.global.error.GlobalExceptionFilter;
import com.example.together.global.security.jwt.JwtTokenFilter;
import com.example.together.global.security.jwt.JwtParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtFilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final ObjectMapper objectMapper;
    private final JwtParser jwtParser;

    @Override
    public void configure(HttpSecurity http) {

        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtParser);
        GlobalExceptionFilter globalExceptionFilter = new GlobalExceptionFilter(objectMapper);

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(globalExceptionFilter, JwtTokenFilter.class);
    }

}
