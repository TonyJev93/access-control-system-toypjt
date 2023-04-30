package com.toy.accesscontrol.datacenter.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.datacenter.domain.vo.DataCenterId;
import lombok.NonNull;

public record DataCenterIdVo(@JsonValue Long value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DataCenterIdVo from(@NonNull Long value) {
        return new DataCenterIdVo(value);
    }

    public static DataCenterIdVo fromDomain(@NonNull DataCenterId domain) {
        return new DataCenterIdVo(domain.value());
    }

    public DataCenterId toDomain() {
        return DataCenterId.from(this.value);
    }
}
