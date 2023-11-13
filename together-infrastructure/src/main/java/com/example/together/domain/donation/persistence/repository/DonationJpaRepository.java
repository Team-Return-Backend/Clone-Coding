package com.example.together.domain.donation.persistence.repository;

import com.example.together.domain.donation.persistence.entity.DonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationJpaRepository extends JpaRepository<DonationEntity, Long> {

}
