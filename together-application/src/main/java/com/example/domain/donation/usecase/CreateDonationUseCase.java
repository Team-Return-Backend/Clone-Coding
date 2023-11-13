package com.example.domain.donation.usecase;

import com.example.common.annotation.UseCase;
import com.example.common.spi.SecurityPort;
import com.example.domain.donation.dto.CreateDonationRequest;
import com.example.domain.donation.model.Donation;
import com.example.domain.donation.model.DonationStatus;
import com.example.domain.donation.spi.CommandDonationPort;
import com.example.domain.user.model.User;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@UseCase
public class CreateDonationUseCase {

    private final SecurityPort securityPort;
    private final CommandDonationPort commandDonationPort;

    public void execute(CreateDonationRequest request) {

        User user = securityPort.getCurrentUser();

        LocalDate dateTime = LocalDate.now();

        commandDonationPort.saveDonation(
                Donation.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .thumbnailImage(request.getThumbnailImage())
                        .donationImage(request.getDonationImage())
                        .createdAt(dateTime)
                        .donationStatus(DonationStatus.WAITING)
                        .groupName(request.getGroupName())
                        .goalAmount(request.getGoalAmount())
                        .donationTag(request.getDonationTag())
                        .donatedAmount(request.getDonatedAmount())
                        .userId(user.getId())
                        .build()
        );
    }
}
