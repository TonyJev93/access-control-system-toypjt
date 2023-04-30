package com.toy.accesscontrol.user.application.port.in;

import com.toy.accesscontrol.user.application.port.dto.UserDto;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;

import java.util.Optional;

public interface UserRetrieveUseCase {
    Optional<UserDto> get(UserIdVo id);
}
