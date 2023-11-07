package com.example.together.domain.user.persistence.mapper;

import com.example.domain.user.model.User;
import com.example.together.domain.user.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    public UserEntity toEntity(User domain) {
        return UserEntity.builder()
                .id(domain.getId())
                .nickname(domain.getNickname())
                .password(domain.getPassword())
                .phoneNumber(domain.getPhoneNumber())
                .email(domain.getEmail())
                .donationAmount(domain.getDonationAmount())
                .donationCounts(domain.getDonationCounts())
                .build();
    }

    public User toDomain(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .nickname(entity.getNickname())
                .password(entity.getPassword())
                .phoneNumber(entity.getPhoneNumber())
                .email(entity.getEmail())
                .donationAmount(entity.getDonationAmount())
                .donationCounts(entity.getDonationCounts())
                .build();
    }
}
