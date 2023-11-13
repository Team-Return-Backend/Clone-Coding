package com.example.together.domain.donation.presentation.dto.request;

import com.example.domain.donation.dto.CreateDonationRequest;
import com.example.domain.donation.model.DonationTag;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateDonationWebRequest {

    private String title;

    private String content;

    private String thumbnailImage;

    private String donationImage;

    private String groupName;

    private Long goalAmount;

    private DonationTag donationTag;

    private Long donatedAmount;

    public CreateDonationRequest toDomainRequest() {
        return CreateDonationRequest.builder()
                .title(this.title)
                .content(this.content)
                .thumbnailImage(this.thumbnailImage)
                .donationImage(this.donationImage)
                .groupName(this.groupName)
                .goalAmount(this.goalAmount)
                .donationTag(this.donationTag)
                .donatedAmount(this.donatedAmount)
                .build();
    }
}
