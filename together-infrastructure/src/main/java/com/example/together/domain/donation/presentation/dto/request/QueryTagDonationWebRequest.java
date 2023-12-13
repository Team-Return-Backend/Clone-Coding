package com.example.together.domain.donation.presentation.dto.request;

import com.example.domain.donation.dto.QueryTagDonationRequest;
import com.example.domain.donation.model.DonationTag;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QueryTagDonationWebRequest {

    private DonationTag donationTag;

    public QueryTagDonationRequest toDomainRequest() {
        return QueryTagDonationRequest.builder()
                .donationTag(this.donationTag)
                .build();

    }
}
