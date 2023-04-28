package com.toy.accesscontrol.datacenter.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record DataCenterName(@JsonValue String value) {
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DataCenterName from(String value) {
        return new DataCenterName(value);
    }
}
