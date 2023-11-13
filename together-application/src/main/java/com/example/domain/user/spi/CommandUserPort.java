package com.example.domain.user.spi;

import com.example.domain.user.model.User;

public interface CommandUserPort {

    User saveUser(User user);
}
