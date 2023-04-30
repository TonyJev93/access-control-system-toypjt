package com.toy.accesscontrol.user.application.port.out;

import com.toy.accesscontrol.user.application.port.dto.UserDto;

public interface SaveUserRepositoryPort {
    UserDto save(UserDto user);
}
