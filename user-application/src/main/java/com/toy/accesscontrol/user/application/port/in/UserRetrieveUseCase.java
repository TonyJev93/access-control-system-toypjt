package com.toy.accesscontrol.user.application.port.in;

import com.toy.accesscontrol.user.application.port.dto.UserDto;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface UserRetrieveUseCase {
    Optional<UserDto> get(@Valid @NotNull UserIdVo id);
}
