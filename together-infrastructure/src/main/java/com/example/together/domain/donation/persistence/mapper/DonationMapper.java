package com.example.together.domain.donation.persistence.mapper;

import com.example.domain.donation.model.Donation;
import com.example.domain.user.exception.UserNotFoundException;
import com.example.together.domain.donation.persistence.entity.DonationEntity;
import com.example.together.domain.user.persistence.entity.UserEntity;
import com.example.together.domain.user.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DonationMapper {

    private final UserJpaRepository userJpaRepository;

    public DonationEntity toEntity(Donation domain) {
        UserEntity userEntity = userJpaRepository.findById(domain.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return DonationEntity.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .content(domain.getContent())
                .thumbnailImage(domain.getThumbnailImage())
                .donationImage(domain.getDonationImage())
                .createdAt(domain.getCreatedAt())
                .donationStatus(domain.getDonationStatus())
                .groupName(domain.getGroupName())
                .goalAmount(domain.getGoalAmount())
                .donationTag(domain.getDonationTag())
                .donatedAmount(domain.getDonatedAmount())
                .user(userEntity)
                .likeCounts(domain.getLikeCounts())
                .build();
    }

    public Donation toDomain(DonationEntity entity) {
        return Donation.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .thumbnailImage(entity.getThumbnailImage())
                .donationImage(entity.getDonationImage())
                .createdAt(entity.getCreatedAt())
                .donationStatus(entity.getDonationStatus())
                .groupName(entity.getGroupName())
                .goalAmount(entity.getGoalAmount())
                .donationTag(entity.getDonationTag())
                .donatedAmount(entity.getDonatedAmount())
                .userId(entity.getUser().getId())
                .likeCounts(entity.getLikeCounts())
                .build();
    }

}
