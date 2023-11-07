package com.example.together.global.security.auth;

import com.example.domain.user.exception.UserNotFoundException;
import com.example.together.domain.user.persistence.entity.UserEntity;
import com.example.together.domain.user.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {

        UserEntity user = userJpaRepository.findByEmail(email)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        return new AuthDetails(user.getEmail());

     }

}
