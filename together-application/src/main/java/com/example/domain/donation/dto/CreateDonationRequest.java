package com.example.domain.donation.dto;

import com.example.domain.donation.model.DonationTag;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateDonationRequest {

    private final String title;

    private final String content;

    private final String thumbnailImage;

    private final String donationImage;

    private final String groupName;

    private final Long goalAmount;

    private final DonationTag donationTag;

    private final Long donatedAmount;
}
