package com.example.together.domain.like.persistence.repository;

import com.example.together.domain.like.persistence.entity.LikeEntity;
import org.springframework.data.repository.CrudRepository;

public interface LikeJpaRepository extends CrudRepository<LikeEntity, Long> {

    boolean existsByUserEntity_IdAndDonationEntity_Id(Long userId, Long donationId);

    void deleteByUserEntity_IdAndDonationEntity_Id(Long userId, Long donationId);

}
