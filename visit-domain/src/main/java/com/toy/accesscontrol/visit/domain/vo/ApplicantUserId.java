package com.toy.accesscontrol.visit.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record ApplicantUserId(@JsonValue String value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ApplicantUserId from(String value) {
        return new ApplicantUserId(value);
    }

}
