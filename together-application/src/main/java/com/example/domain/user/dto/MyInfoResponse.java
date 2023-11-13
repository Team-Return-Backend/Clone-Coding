package com.example.domain.user.dto;

import com.example.domain.user.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyInfoResponse {

    private final String nickname;

    private final int donationAmount;

    private final int donationCounts;

    public static MyInfoResponse of(User user) {
        return MyInfoResponse.builder()
                .nickname(user.getNickname())
                .donationAmount(user.getDonationAmount())
                .donationCounts(user.getDonationCounts())
                .build();
    }

}
