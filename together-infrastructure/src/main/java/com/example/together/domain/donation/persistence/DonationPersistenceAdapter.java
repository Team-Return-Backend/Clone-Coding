package com.example.together.domain.donation.persistence;

import com.example.domain.donation.model.Donation;
import com.example.domain.donation.spi.DonationPort;
import com.example.domain.user.model.User;
import com.example.together.domain.donation.persistence.mapper.DonationMapper;
import com.example.together.domain.donation.persistence.repository.DonationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DonationPersistenceAdapter implements DonationPort {

    private final DonationMapper donationMapper;
    private final DonationJpaRepository donationJpaRepository;

    @Override
    public Donation saveDonation(Donation donation) {
        return donationMapper.toDomain(
                donationJpaRepository.save(donationMapper.toEntity(donation))
        );
    }

    @Override
    public Optional<Donation> queryDonationById(Long id) {
        return donationJpaRepository.findById(id).map(donationMapper::toDomain);    }
}
