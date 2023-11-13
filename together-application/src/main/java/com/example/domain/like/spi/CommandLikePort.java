package com.example.domain.like.spi;

import com.example.domain.like.model.UserLike;

public interface CommandLikePort {

    void saveLike(UserLike like);

    void deleteByUserIdAndDonationId(Long userId, Long donationId);
}
