package com.toy.accesscontrol.user.application.service;

import com.toy.accesscontrol.user.application.port.dto.UserDto;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;
import com.toy.accesscontrol.user.application.port.in.UserRetrieveUseCase;
import com.toy.accesscontrol.user.application.port.out.LoadUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRetrieveService implements UserRetrieveUseCase {

    private final LoadUserRepositoryPort loadUserRepositoryPort;

    @Override
    public Optional<UserDto> get(UserIdVo id) {
        return loadUserRepositoryPort.findBy(id);
    }
}
