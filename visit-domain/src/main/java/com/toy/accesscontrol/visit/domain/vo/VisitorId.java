package com.toy.accesscontrol.visit.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record VisitorId(@JsonValue Long value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static VisitorId from(Long value) {
        return new VisitorId(value);
    }

}
