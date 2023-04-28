package com.toy.accesscontrol.user.application.service;

import com.toy.accesscontrol.user.application.port.in.UserSignUpUseCase;
import com.toy.accesscontrol.user.application.port.out.LoadUserRepositoryPort;
import com.toy.accesscontrol.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignUpService implements UserSignUpUseCase {

    private final LoadUserRepositoryPort loadUserRepository;

    @Override
    public User signUp(SignUpRequest request) {
        var user = User.create(request.userId(), request.password(), request.name());

        User signedUpUser = loadUserRepository.save(user);

        return signedUpUser;
    }
}
