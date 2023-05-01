package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.VisitReason;

public record VisitReasonVo(@JsonValue String value) {

    @JsonCreator
    public static VisitReasonVo from(String value) {
        return new VisitReasonVo(value);
    }

    public static VisitReasonVo fromDomain(VisitReason domain) {
        return new VisitReasonVo(domain.value());
    }

    public VisitReason toDomain() {
        return VisitReason.from(this.value);
    }
}
