package com.example.domain.user.spi;

import com.example.domain.user.model.User;

import java.util.Optional;

public interface QueryUserPort {

    boolean existsUserByEmail(String email);

    Optional<User> queryUserByEmail(String email);
}
