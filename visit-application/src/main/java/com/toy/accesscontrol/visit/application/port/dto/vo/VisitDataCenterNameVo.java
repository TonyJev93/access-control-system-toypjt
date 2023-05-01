package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record VisitDataCenterNameVo(@JsonValue String value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static VisitDataCenterNameVo from(String value) {
        return new VisitDataCenterNameVo(value);
    }
}
