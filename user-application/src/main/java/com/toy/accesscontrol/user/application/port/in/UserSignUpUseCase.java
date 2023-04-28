package com.toy.accesscontrol.user.application.port.in;

import com.toy.accesscontrol.user.domain.User;
import com.toy.accesscontrol.user.domain.vo.Password;
import com.toy.accesscontrol.user.domain.vo.UserId;
import com.toy.accesscontrol.user.domain.vo.UserName;

public interface UserSignUpUseCase {

    User signUp(SignUpRequest toDomain);

    record SignUpRequest(
            UserId userId,
            Password password,
            UserName name
    ) {
    }
}
