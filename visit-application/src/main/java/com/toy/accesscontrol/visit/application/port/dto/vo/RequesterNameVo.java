package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.RequesterName;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record RequesterNameVo(
        @JsonValue
        @NotEmpty
        @Length(min = LENGTH_MIN, max = LENGTH_MAX)
        String value
) {

    public static final int LENGTH_MIN = 2;
    public static final int LENGTH_MAX = 10;

    @JsonCreator
    public static RequesterNameVo from(String value) {
        return new RequesterNameVo(value);
    }

    public static RequesterNameVo fromDomain(RequesterName domain) {
        return new RequesterNameVo(domain.value());
    }

    public RequesterName toDomain() {
        return RequesterName.from(this.value);
    }
}
