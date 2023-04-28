package com.toy.accesscontrol.user.adapter.in.dto;

import com.toy.accesscontrol.user.domain.User;
import com.toy.accesscontrol.user.domain.vo.UserId;
import com.toy.accesscontrol.user.domain.vo.UserName;
import com.toy.accesscontrol.user.domain.vo.UserRole;

public record UserDto(
        Long id,
        UserId userId,
        UserName name,
        UserRole role
) {
    public static UserDto from(User user) {
        return new UserDto(
                user.getId(),
                user.getUserId(),
                user.getName(),
                user.getRole()
        );
    }
}
