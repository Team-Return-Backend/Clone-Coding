package com.example.domain.user.model;

import com.example.common.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@Aggregate
public class User {

    private final Long id;

    private final String nickname;

    private final String password;

    private final String phoneNumber;

    private final String email;

    private final int donationAmount;

    private final int donationCounts;

}
