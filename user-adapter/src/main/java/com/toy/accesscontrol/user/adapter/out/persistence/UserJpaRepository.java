package com.toy.accesscontrol.user.adapter.out.persistence;

import com.toy.accesscontrol.user.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
    boolean existsByUserId(String userId);
}
