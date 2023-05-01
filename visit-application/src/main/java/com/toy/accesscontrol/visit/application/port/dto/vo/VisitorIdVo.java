package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.VisitorId;
import lombok.NonNull;

public record VisitorIdVo(@JsonValue Long value) {

    @JsonCreator
    public static VisitorIdVo from(@NonNull Long value) {
        return new VisitorIdVo(value);
    }

    public static VisitorIdVo fromDomain(@NonNull VisitorId domain) {
        return new VisitorIdVo(domain.value());
    }

    public VisitorId toDomain() {
        return VisitorId.from(this.value);
    }
}
