package com.toy.accesscontrol.user.application.port.out;

import com.toy.accesscontrol.user.domain.User;

public interface LoadUserRepositoryPort {
    User save(User user);
}
