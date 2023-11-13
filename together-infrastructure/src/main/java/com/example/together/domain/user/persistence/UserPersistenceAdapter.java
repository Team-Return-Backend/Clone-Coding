package com.example.together.domain.user.persistence;

import com.example.domain.user.model.User;
import com.example.domain.user.spi.UserPort;
import com.example.together.domain.user.persistence.mapper.UserMapper;
import com.example.together.domain.user.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;


    @Override
    public boolean existsUserByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public Optional<User> queryUserByEmail(String email) {
        return userJpaRepository.findByEmail(email).map(userMapper::toDomain);
    }

    @Override
    public Optional<User> queryUserById(Long id) {
        return userJpaRepository.findById(id).map(userMapper::toDomain);
    }

    @Override
    public User saveUser(User user) {
        return userMapper.toDomain(
                userJpaRepository.save(userMapper.toEntity(user))
        );
    }
}
