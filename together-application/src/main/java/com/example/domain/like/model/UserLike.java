package com.example.domain.like.model;

import com.example.common.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@Aggregate
public class UserLike {

    private Long id;

    private Long userId;

    private Long donationId;

}
