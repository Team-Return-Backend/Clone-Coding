package com.example.common.spi;


import com.example.domain.user.model.User;

public interface SecurityPort {

    User getCurrentUser();

}
