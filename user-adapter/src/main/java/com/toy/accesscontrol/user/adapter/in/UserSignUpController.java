package com.toy.accesscontrol.user.adapter.in;


import com.toy.accesscontrol.user.adapter.in.dto.SignUpRequestDto;
import com.toy.accesscontrol.user.adapter.in.dto.UserDto;
import com.toy.accesscontrol.user.application.port.in.UserSignUpUseCase;
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
    public UserDto signUp(@RequestBody SignUpRequestDto request) {
        var user = userSignUpUseCase.signUp(request.toPortRequest());
        return UserDto.from(user);
    }
}
