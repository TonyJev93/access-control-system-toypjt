package com.toy.accesscontrol.user.application.port.in;

import com.toy.accesscontrol.user.application.port.dto.UserDto;
import com.toy.accesscontrol.user.application.port.dto.vo.PasswordVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserNameVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserSignUpUseCase {

    UserDto signUp(@Valid @NotNull SignUpRequestDto signUpRequest);

    record SignUpRequestDto(
            @Valid @NotNull UserIdVo userId,
            @Valid @NotNull PasswordVo password,
            @Valid @NotNull UserNameVo name
    ) {
    }
}
