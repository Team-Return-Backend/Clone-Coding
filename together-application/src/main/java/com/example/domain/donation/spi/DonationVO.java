package com.example.domain.donation.spi;

import com.example.domain.donation.model.DonationTag;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DonationVO {

    private final Long id;

    private final String title;

    private final String content;

    private final String donationImage;

    private LocalDate createdAt;

    private final String groupName;

    private final Long goalAmount;

    private final DonationTag donationTag;

    private final Long donatedAmount;

    private final Long userId;

    private final int likeCounts;
}
