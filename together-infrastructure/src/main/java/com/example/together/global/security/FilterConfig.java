package com.example.together.global.security;

import com.example.together.global.error.GlobalExceptionFilter;
import com.example.together.global.security.jwt.JwtFilter;
import com.example.together.global.security.jwt.JwtParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtParser jwtParser;
    private final ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity http) {
        http.addFilterBefore(new JwtFilter(jwtParser), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new GlobalExceptionFilter(objectMapper), JwtFilter.class);
    }
}
