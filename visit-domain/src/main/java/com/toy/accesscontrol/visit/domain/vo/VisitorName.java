package com.toy.accesscontrol.visit.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record VisitorName(@JsonValue String value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static VisitorName from(String value) {
        return new VisitorName(value);
    }

}
