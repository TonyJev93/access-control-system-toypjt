package com.toy.accesscontrol.user.adapter.in.api;


import com.toy.accesscontrol.user.adapter.in.api.dto.UserResponse;
import com.toy.accesscontrol.user.application.port.in.UserSignUpUseCase;
import com.toy.accesscontrol.user.application.port.in.UserSignUpUseCase.SignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserSignUpController {

    private final UserSignUpUseCase userSignUpUseCase;

    @PostMapping("/sign-up")
    public UserResponse signUp(@RequestBody SignUpRequestDto request) {
        var signUpUser = userSignUpUseCase.signUp(request);

        return UserResponse.from(signUpUser);
    }
}
