package com.toy.accesscontrol.user.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.user.domain.vo.UserId;

public record UserIdVo(@JsonValue String value) {
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static UserIdVo from(String value) {
        return new UserIdVo(value);
    }

    public static UserIdVo fromDomain(UserId domain) {
        return new UserIdVo(domain.value());
    }

    public UserId toDomain() {
        return UserId.from(this.value);
    }
}
