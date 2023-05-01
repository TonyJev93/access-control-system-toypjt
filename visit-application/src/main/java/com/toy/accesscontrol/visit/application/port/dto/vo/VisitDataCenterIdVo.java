package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.VisitDataCenterId;
import lombok.NonNull;

public record VisitDataCenterIdVo(@JsonValue Long value) {

    @JsonCreator
    public static VisitDataCenterIdVo from(@NonNull Long value) {
        return new VisitDataCenterIdVo(value);
    }

    public static VisitDataCenterIdVo fromDomain(@NonNull VisitDataCenterId domain) {
        return new VisitDataCenterIdVo(domain.value());
    }

    public VisitDataCenterId toDomain() {
        return VisitDataCenterId.from(this.value);
    }
}
