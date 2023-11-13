package com.example.domain.like.spi;

public interface QueryLikePort {

    boolean existsByUserIdAndDonationId(Long userId, Long donationId);

}
