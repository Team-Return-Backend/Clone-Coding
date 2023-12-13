package com.example.domain.donation.spi;


import com.example.domain.donation.model.Donation;
import com.example.domain.donation.model.DonationTag;

import java.util.List;
import java.util.Optional;

public interface QueryDonationPort {

    Optional<Donation> queryDonationById(Long id);

    List<DonationVO> queryDonationList();

    List<DonationVO> queryDonationListByTag(DonationTag donationTag);

}
