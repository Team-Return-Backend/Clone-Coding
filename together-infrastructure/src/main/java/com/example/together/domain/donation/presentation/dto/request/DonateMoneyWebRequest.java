package com.example.together.domain.donation.presentation.dto.request;

import com.example.domain.donation.dto.DonateMoneyRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DonateMoneyWebRequest {

    private int moneyAmount;

    public DonateMoneyRequest toDomainRequest() {
        return DonateMoneyRequest.builder()
                .moneyAmount(this.moneyAmount)
                .build();

    }
}
