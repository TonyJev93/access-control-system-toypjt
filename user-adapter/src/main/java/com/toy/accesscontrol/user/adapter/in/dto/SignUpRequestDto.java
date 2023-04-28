package com.toy.accesscontrol.user.adapter.in.dto;

import com.toy.accesscontrol.user.application.port.in.UserSignUpUseCase.SignUpRequest;
import com.toy.accesscontrol.user.domain.vo.Password;
import com.toy.accesscontrol.user.domain.vo.UserId;
import com.toy.accesscontrol.user.domain.vo.UserName;

public record SignUpRequestDto(
        UserId userId,
        Password password,
        UserName name,
        String test
) {
    public SignUpRequest toPortRequest() {
        return new SignUpRequest(
                userId,
                password,
                name
        );
    }
}
