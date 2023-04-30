package com.toy.accesscontrol.datacenter.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record DataCenterId(@JsonValue Long value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DataCenterId from(Long value) {
        return new DataCenterId(value);
    }

}
