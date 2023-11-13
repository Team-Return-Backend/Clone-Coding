package com.example.domain.like.usecase;

import com.example.common.annotation.UseCase;
import com.example.common.spi.SecurityPort;
import com.example.domain.donation.model.Donation;
import com.example.domain.donation.spi.QueryDonationPort;
import com.example.domain.like.exception.DonationNotFoundException;
import com.example.domain.like.model.UserLike;
import com.example.domain.like.spi.CommandLikePort;
import com.example.domain.like.spi.QueryLikePort;
import com.example.domain.user.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class LikeUseCase {

    private final QueryLikePort queryLikePort;
    private final QueryDonationPort queryDonationPort;
    private final SecurityPort securityPort;
    private final CommandLikePort commandLikePort;

    public void execute(Long donationId) {

        User currentUser = securityPort.getCurrentUser();

        Donation donation = queryDonationPort.queryDonationById(donationId)
                .orElseThrow(() -> DonationNotFoundException.EXCEPTION);


        if (queryLikePort.existsByUserIdAndDonationId(currentUser.getId(), donationId)) {
            commandLikePort.deleteByUserIdAndDonationId(currentUser.getId(), donationId);
            donation.minusLike();
        }
        else {
            commandLikePort.saveLike(
                    UserLike.builder()
                            .donationId(donation.getId())
                            .userId(currentUser.getId())
                            .build()
            );
            donation.addLike();
        }

    }
}
