package com.toy.accesscontrol.user.application.port.dto;

import com.toy.accesscontrol.user.application.port.dto.vo.PasswordVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserNameVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserRoleVo;
import com.toy.accesscontrol.user.domain.User;

public record UserDto(
        UserIdVo userId,
        PasswordVo password,
        UserNameVo name,
        UserRoleVo role
) {
    public static UserDto fromDomain(User user) {
        return new UserDto(
                UserIdVo.fromDomain(user.getUserId()),
                PasswordVo.fromDomain(user.getPassword()),
                UserNameVo.fromDomain(user.getName()),
                UserRoleVo.valueOf(user.getRole().name())
        );
    }

    public static UserDto of(UserIdVo userId, PasswordVo password, UserNameVo name, UserRoleVo role) {
        return new UserDto(
                userId,
                password,
                name,
                role
        );
    }
}