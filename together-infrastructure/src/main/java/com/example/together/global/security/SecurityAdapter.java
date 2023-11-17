package com.example.together.global.security;

import com.example.common.spi.SecurityPort;
import com.example.domain.user.exception.UserNotFoundException;
import com.example.domain.user.model.User;
import com.example.together.domain.user.persistence.entity.UserEntity;
import com.example.together.domain.user.persistence.mapper.UserMapper;
import com.example.together.domain.user.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SecurityAdapter implements SecurityPort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;
    @Override
    public User getCurrentUser() {

        UserEntity email = userJpaRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
        return userMapper.toDomain(email);
    }

}
