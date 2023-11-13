package com.example.domain.donation.usecase;

import com.example.common.annotation.UseCase;
import com.example.common.spi.SecurityPort;
import com.example.domain.donation.dto.DonateMoneyRequest;
import com.example.domain.user.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class DonateMoneyUseCase {

    private final SecurityPort securityPort;

    public void execute(DonateMoneyRequest request) {
        User user = securityPort.getCurrentUser();

        user.donate(request.getMoneyAmount());
    }



}
