package com.example.together.domain.like.persistence;

import com.example.domain.like.model.UserLike;
import com.example.domain.like.spi.LikePort;
import com.example.together.domain.like.persistence.mapper.LikeMapper;
import com.example.together.domain.like.persistence.repository.LikeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikePersistenceAdapter implements LikePort {

    private final LikeMapper likeMapper;
    private final LikeJpaRepository likeJpaRepository;

    @Override
    public void saveLike(UserLike like) {
        likeMapper.toDomain(
                likeJpaRepository.save(likeMapper.toEntity(like))
        );
    }

    @Override
    public void deleteByUserIdAndDonationId(Long userId, Long donationId) {
        likeJpaRepository.deleteByUserEntity_IdAndDonationEntity_Id(userId, donationId);
    }

    @Override
    public boolean existsByUserIdAndDonationId(Long userId, Long donationId) {
        return likeJpaRepository.existsByUserEntity_IdAndDonationEntity_Id(userId, donationId);
    }
}
