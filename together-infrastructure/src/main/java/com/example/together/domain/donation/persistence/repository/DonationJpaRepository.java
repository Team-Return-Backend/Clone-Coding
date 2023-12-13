package com.example.together.domain.donation.persistence.repository;

import com.example.domain.donation.model.DonationTag;
import com.example.together.domain.donation.persistence.entity.DonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationJpaRepository extends JpaRepository<DonationEntity, Long> {

    List<DonationEntity> findAllByDonationTag(DonationTag donationTag);

}
