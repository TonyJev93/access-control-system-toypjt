package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.VisitorName;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record VisitorNameVo(
        @JsonValue
        @NotEmpty
        @Length(min = LENGTH_MIN, max = LENGTH_MAX)
        String value
) {
    public static final int LENGTH_MIN = 2;
    public static final int LENGTH_MAX = 10;

    @JsonCreator
    public static VisitorNameVo from(String value) {
        return new VisitorNameVo(value);
    }

    public static VisitorNameVo fromDomain(VisitorName domain) {
        return new VisitorNameVo(domain.value());
    }

    public VisitorName toDomain() {
        return VisitorName.from(this.value);
    }
}
