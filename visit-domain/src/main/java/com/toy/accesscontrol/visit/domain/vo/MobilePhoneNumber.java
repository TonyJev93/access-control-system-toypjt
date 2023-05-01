package com.toy.accesscontrol.visit.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record MobilePhoneNumber(@JsonValue String value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static MobilePhoneNumber from(String value) {
        return new MobilePhoneNumber(value);
    }

}
