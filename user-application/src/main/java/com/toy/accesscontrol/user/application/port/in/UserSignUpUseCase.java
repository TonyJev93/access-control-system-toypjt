package com.toy.accesscontrol.user.application.port.in;

import com.toy.accesscontrol.user.application.port.dto.UserDto;
import com.toy.accesscontrol.user.application.port.dto.vo.PasswordVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserNameVo;

public interface UserSignUpUseCase {

    UserDto signUp(SignUpRequestDto signUpRequest);

    record SignUpRequestDto(
            UserIdVo userId,
            PasswordVo password,
            UserNameVo name
    ) {
    }
}
