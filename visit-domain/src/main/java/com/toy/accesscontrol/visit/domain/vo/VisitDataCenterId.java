package com.toy.accesscontrol.visit.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record VisitDataCenterId(@JsonValue Long value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static VisitDataCenterId from(Long value) {
        return new VisitDataCenterId(value);
    }

}
