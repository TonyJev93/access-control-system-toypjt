package com.toy.accesscontrol.user.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.user.domain.vo.UserName;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record UserNameVo(
        @JsonValue
        @NotEmpty
        @Length(min = LENGTH_MIN, max = LENGTH_MAX)
        String value
) {
    public static final int LENGTH_MIN = 2;
    public static final int LENGTH_MAX = 10;

    @JsonCreator
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