package com.toy.accesscontrol.user.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.user.domain.vo.Password;

public record PasswordVo(@JsonValue String value) {
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PasswordVo from(String value) {
        return new PasswordVo(value);
    }

    public static PasswordVo fromDomain(Password domain) {
        return PasswordVo.from(domain.value());
    }

    public Password toDomain() {
        return Password.from(this.value);
    }
}
