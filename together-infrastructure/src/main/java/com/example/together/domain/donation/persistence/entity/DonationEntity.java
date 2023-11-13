package com.example.together.domain.donation.persistence.entity;

import com.example.domain.donation.model.DonationStatus;
import com.example.domain.donation.model.DonationTag;
import com.example.together.domain.user.persistence.entity.UserEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_donation")
@Entity
public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(50)")
    private String title;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String content;

    @NotNull
    @Column(columnDefinition = "VARCHAR(300)")
    private String thumbnailImage;

    @NotNull
    @Column(columnDefinition = "VARCHAR(300)")
    private String donationImage;

    @NotNull
    private LocalDate createdAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DonationStatus donationStatus;

    @NotNull
    @Column(columnDefinition = "VARCHAR(50)")
    private String groupName;

    @NotNull
    @Column
    private Long goalAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DonationTag donationTag;

    @Column
    private Long donatedAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column
    private int likeCounts;

    @Builder
    public DonationEntity(Long id, String title, String content, String thumbnailImage, String donationImage, LocalDate createdAt, DonationStatus donationStatus, String groupName, Long goalAmount, DonationTag donationTag, Long donatedAmount, UserEntity user, int likeCounts) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.thumbnailImage = thumbnailImage;
        this.donationImage =donationImage;
        this.createdAt = createdAt;
        this.donationStatus = donationStatus;
        this.groupName = groupName;
        this.goalAmount = goalAmount;
        this.donationTag = donationTag;
        this.donatedAmount = donatedAmount;
        this.user = user;
        this.likeCounts = likeCounts;
    }
}
