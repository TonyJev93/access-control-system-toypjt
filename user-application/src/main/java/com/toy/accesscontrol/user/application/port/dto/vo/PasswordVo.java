package com.toy.accesscontrol.user.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.user.domain.vo.Password;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record PasswordVo(
        @JsonValue
        @NotEmpty
        @Length(min = LENGTH_MIN, max = LENGTH_MAX)
        @Pattern(regexp = REG_PASSWORD)
        String value
) {

    public static final int LENGTH_MIN = 8;
    public static final int LENGTH_MAX = 128;
    public static final String REG_PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";


    @JsonCreator
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
