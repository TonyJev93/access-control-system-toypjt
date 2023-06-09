package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.RequesterName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record RequesterNameVo(
        @JsonValue
        @NotEmpty
        @Size(min = LENGTH_MIN, max = LENGTH_MAX)
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

    public interface Mapper {
        default String requesterNameVo(RequesterNameVo value) {
            return Optional.ofNullable(value).map(RequesterNameVo::value).orElse(null);
        }

        default RequesterNameVo requesterNameVo(String value) {
            return Optional.ofNullable(value).map(RequesterNameVo::from).orElse(null);
        }
    }
}
