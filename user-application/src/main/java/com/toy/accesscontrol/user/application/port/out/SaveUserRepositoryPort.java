package com.toy.accesscontrol.user.application.port.out;

import com.toy.accesscontrol.user.application.port.dto.UserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface SaveUserRepositoryPort {
    UserDto save(@Valid @NotNull UserDto user);
}
