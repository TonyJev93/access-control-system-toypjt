package com.toy.accesscontrol.user.adapter.out.persistence;

import com.toy.accesscontrol.user.adapter.out.persistence.entity.UserEntity;
import com.toy.accesscontrol.user.application.port.dto.UserDto;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;
import com.toy.accesscontrol.user.application.port.out.LoadUserRepositoryPort;
import com.toy.accesscontrol.user.application.port.out.SaveUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements SaveUserRepositoryPort, LoadUserRepositoryPort {

    private final UserJpaRepository repository;

    @Override
    public UserDto save(UserDto dto) {
        return repository.save(
                UserEntity.from(dto)
        ).toDto();
    }

    @Override
    public boolean isUserIdExist(UserIdVo userId) {
        return repository.existsByUserId(userId.value());
    }

    @Override
    public Optional<UserDto> findBy(UserIdVo id) {
        return repository.findById(id.value())
                .map(UserEntity::toDto);
    }
}
