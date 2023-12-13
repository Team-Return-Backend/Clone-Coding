package com.example.domain.donation.dto;

import com.example.domain.donation.model.DonationStatus;
import com.example.domain.donation.model.DonationTag;
import com.example.domain.donation.spi.DonationVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class QueryDonationListResponse {

    private final List<DonationVO> donations;

}
