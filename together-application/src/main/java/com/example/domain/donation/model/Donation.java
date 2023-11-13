package com.example.domain.donation.model;

import com.example.common.annotation.Aggregate;
import com.example.domain.user.model.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder(toBuilder = true)
@Aggregate
public class Donation {

    private final Long id;

    private final String title;

    private final String content;

    private final String thumbnailImage;

    private final String donationImage;

    private LocalDate createdAt;

    private DonationStatus donationStatus;

    private final String groupName;

    private final Long goalAmount;

    private final DonationTag donationTag;

    private final Long donatedAmount;

    private final Long userId;

    private final int likeCounts;

    public Donation addLike() {
        return this.toBuilder()
                .likeCounts(this.likeCounts + 1)
                .build();
    }

    public Donation minusLike() {
        return this.toBuilder()
                .likeCounts(this.likeCounts - 1)
                .build();
    }
}
