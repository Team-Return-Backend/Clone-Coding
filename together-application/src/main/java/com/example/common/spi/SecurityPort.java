package com.example.common.spi;


import com.example.domain.user.model.User;

public interface SecurityPort {

    boolean isPasswordMatch(String rawPassword, String encodedPassword);

    User getCurrentUser();

}
