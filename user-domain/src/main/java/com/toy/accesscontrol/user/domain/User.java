package com.toy.accesscontrol.user.domain;

import com.toy.accesscontrol.user.domain.vo.Password;
import com.toy.accesscontrol.user.domain.vo.UserId;
import com.toy.accesscontrol.user.domain.vo.UserName;
import com.toy.accesscontrol.user.domain.vo.UserRole;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class User {
    private UserId userId;
    private Password password;
    private UserName name;
    private UserRole role;

    public static User signUp(UserId userId, Password password, UserName name) {
        return User.builder()
                .userId(userId)
                .password(password)
                .name(name)
                .role(UserRole.MEMBER)
                .build();
    }

    public static User of(UserId userId, Password password, UserName name, UserRole role) {
        return new User(userId, password, name, role);
    }
}
