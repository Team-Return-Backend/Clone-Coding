package com.example.together.domain.user.persistence.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_user")
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(25)")
    private String nickname;

    @NotNull
    @Column(columnDefinition = "VARCHAR(25)", unique = true)
    private String password;

    @NotNull
    @Column(columnDefinition = "VARCHAR(11)", unique = true)
    private String phoneNumber;

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)", unique = true)
    private String email;

    @NotNull
    @Column(columnDefinition = "INT")
    private int donationAmount;

    @NotNull
    @Column(columnDefinition = "INT")
    private int donationCounts;

    @Builder
    public UserEntity(Long id, String nickname, String password, String phoneNumber, String email, int donationAmount, int donationCounts) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.donationAmount = donationAmount;
        this.donationCounts = donationCounts;
    }
}
