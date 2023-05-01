package com.toy.accesscontrol.user.adapter.in.api;


import com.toy.accesscontrol.user.adapter.global.api.UserApiResponse;
import com.toy.accesscontrol.user.adapter.in.api.dto.UserResponse;
import com.toy.accesscontrol.user.application.port.in.UserSignUpUseCase;
import com.toy.accesscontrol.user.application.port.in.UserSignUpUseCase.SignUpRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserSignUpController {

    private final UserSignUpUseCase userSignUpUseCase;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public UserApiResponse<UserResponse> signUp(@Valid @RequestBody SignUpRequestDto request) {
        var signUpUser = userSignUpUseCase.signUp(request);

        return UserApiResponse.of(
                UserResponse.from(signUpUser)
        );
    }
}
