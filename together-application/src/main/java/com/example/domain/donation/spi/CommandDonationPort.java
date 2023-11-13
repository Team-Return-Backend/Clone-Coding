package com.example.domain.donation.spi;

import com.example.domain.donation.model.Donation;

public interface CommandDonationPort {

    Donation saveDonation(Donation donation);
}
