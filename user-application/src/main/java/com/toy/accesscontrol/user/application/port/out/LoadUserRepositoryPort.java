package com.toy.accesscontrol.user.application.port.out;

import com.toy.accesscontrol.user.application.port.dto.UserDto;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;

import java.util.Optional;

public interface LoadUserRepositoryPort {
    boolean isUserIdExist(UserIdVo userId);

    Optional<UserDto> findBy(UserIdVo id);
}
