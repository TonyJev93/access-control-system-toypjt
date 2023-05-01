package com.toy.accesscontrol.visit.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record VisitId(@JsonValue Long value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static VisitId from(Long value) {
        return new VisitId(value);
    }

}
