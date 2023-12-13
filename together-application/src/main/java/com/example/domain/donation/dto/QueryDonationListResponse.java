package com.example.domain.donation.dto;

import com.example.domain.donation.spi.DonationVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryDonationListResponse {

    private final List<DonationVO> donations;

}
