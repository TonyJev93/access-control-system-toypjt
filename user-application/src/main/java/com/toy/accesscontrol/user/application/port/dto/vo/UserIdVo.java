package com.toy.accesscontrol.user.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.user.domain.vo.UserId;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record UserIdVo(
        @JsonValue
        @NotEmpty
        @Length(min = LENGTH_MIN, max = LENGTH_MAX)
        String value) {

    public static final int LENGTH_MIN = 4;
    public static final int LENGTH_MAX = 10;

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
