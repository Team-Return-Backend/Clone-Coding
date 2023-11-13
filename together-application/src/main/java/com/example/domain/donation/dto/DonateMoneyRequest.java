package com.example.domain.donation.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DonateMoneyRequest {

    private int moneyAmount;
}
