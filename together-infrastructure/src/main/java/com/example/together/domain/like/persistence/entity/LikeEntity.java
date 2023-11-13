package com.example.together.domain.like.persistence.entity;

import com.example.together.domain.donation.persistence.entity.DonationEntity;
import com.example.together.domain.user.persistence.entity.UserEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_like")
@Entity
public class LikeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donation_id", nullable = false)
    private DonationEntity donationEntity;

    @Builder
    public LikeEntity(Long id, UserEntity userEntity, DonationEntity donationEntity) {
        this.id = id;
        this.userEntity = userEntity;
        this.donationEntity = donationEntity;
    }

}
