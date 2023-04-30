package com.toy.accesscontrol.user.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.user.domain.vo.UserName;

public record UserNameVo(@JsonValue String value) {
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static UserNameVo from(String value) {
        return new UserNameVo(value);
    }

    public static UserNameVo fromDomain(UserName domain) {
        return UserNameVo.from(domain.value());
    }

    public UserName toDomain() {
        return UserName.from(this.value);
    }
}