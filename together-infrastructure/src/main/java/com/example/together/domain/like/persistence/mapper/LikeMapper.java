package com.example.together.domain.like.persistence.mapper;

import com.example.domain.like.exception.DonationNotFoundException;
import com.example.domain.like.model.UserLike;
import com.example.domain.user.exception.UserNotFoundException;
import com.example.domain.user.model.User;
import com.example.together.domain.donation.persistence.entity.DonationEntity;
import com.example.together.domain.donation.persistence.repository.DonationJpaRepository;
import com.example.together.domain.like.persistence.entity.LikeEntity;
import com.example.together.domain.user.persistence.entity.UserEntity;
import com.example.together.domain.user.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikeMapper {

    private final UserJpaRepository userJpaRepository;
    private final DonationJpaRepository donationJpaRepository;

    public LikeEntity toEntity(UserLike domain) {

        UserEntity userEntity = userJpaRepository.findById(domain.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        DonationEntity donationEntity = donationJpaRepository.findById(domain.getDonationId())
                .orElseThrow(() -> DonationNotFoundException.EXCEPTION);

        return LikeEntity.builder()
                .id(domain.getId())
                .userEntity(userEntity)
                .donationEntity(donationEntity)
                .build();
    }

    public UserLike toDomain(LikeEntity entity) {
        return UserLike.builder()
                .id(entity.getId())
                .userId(entity.getUserEntity().getId())
                .donationId(entity.getDonationEntity().getId())
                .build();
    }

}
