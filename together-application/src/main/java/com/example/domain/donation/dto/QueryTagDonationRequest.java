package com.example.domain.donation.dto;

import com.example.domain.donation.model.DonationTag;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryTagDonationRequest {

    private DonationTag donationTag;

}
