package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.VisitId;
import lombok.NonNull;

public record VisitIdVo(@JsonValue Long value) {

    @JsonCreator
    public static VisitIdVo from(@NonNull Long value) {
        return new VisitIdVo(value);
    }

    public static VisitIdVo fromDomain(@NonNull VisitId domain) {
        return new VisitIdVo(domain.value());
    }

    public VisitId toDomain() {
        return VisitId.from(this.value);
    }
}
