package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.VisitorName;

public record VisitorNameVo(@JsonValue String value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static VisitorNameVo from(String value) {
        return new VisitorNameVo(value);
    }

    public static VisitorNameVo fromDomain(VisitorName domain) {
        return new VisitorNameVo(domain.value());
    }

    public VisitorName toDomain() {
        return VisitorName.from(this.value);
    }
}
