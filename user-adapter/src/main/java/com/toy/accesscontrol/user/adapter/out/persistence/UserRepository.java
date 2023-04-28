package com.toy.accesscontrol.user.adapter.out.persistence;

import com.toy.accesscontrol.user.adapter.out.persistence.entity.UserEntity;
import com.toy.accesscontrol.user.application.port.out.LoadUserRepositoryPort;
import com.toy.accesscontrol.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository implements LoadUserRepositoryPort {

    private final UserJpaRepository repository;

    @Override
    public User save(User user) {
        return repository.save(UserEntity.from(user)).toDomain();
    }
}
