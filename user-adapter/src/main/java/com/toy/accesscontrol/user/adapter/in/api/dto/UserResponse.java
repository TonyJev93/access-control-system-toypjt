package com.toy.accesscontrol.user.adapter.in.api.dto;

import com.toy.accesscontrol.user.application.port.dto.UserDto;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserNameVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserRoleVo;

public record UserResponse(
        UserIdVo userId,
        UserNameVo name,
        UserRoleVo role
) {
    public static UserResponse from(UserDto dto) {
        return new UserResponse(
                dto.userId(),
                dto.name(),
                dto.role()
        );
    }
}
