package com.toy.accesscontrol.user.application.service;

import com.toy.accesscontrol.user.application.port.dto.UserDto;
import com.toy.accesscontrol.user.application.port.in.UserSignUpUseCase;
import com.toy.accesscontrol.user.application.port.out.LoadUserRepositoryPort;
import com.toy.accesscontrol.user.application.port.out.SaveUserRepositoryPort;
import com.toy.accesscontrol.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignUpService implements UserSignUpUseCase {

    private final SaveUserRepositoryPort saveUserRepositoryPort;
    private final LoadUserRepositoryPort loadUserRepositoryPort;

    private static UserDto signUpUserDto(SignUpRequestDto request) {
        return UserDto.fromDomain(
                User.signUp(
                        request.userId().toDomain(),
                        request.password().toDomain(),
                        request.name().toDomain()
                )
        );
    }

    @Override
    public UserDto signUp(SignUpRequestDto signUpRequest) {
        var userIdExist = loadUserRepositoryPort.isUserIdExist(signUpRequest.userId());

        if (userIdExist) {
            throw new RuntimeException("이미 존재하는 아이디");
        }

        return saveUserRepositoryPort.save(
                signUpUserDto(signUpRequest)
        );
    }
}
