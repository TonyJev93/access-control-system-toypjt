package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.VisitReason;

import java.util.Optional;

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

    public interface Mapper {
        default String visitReasonVo(VisitReasonVo value) {
            return Optional.ofNullable(value).map(VisitReasonVo::value).orElse(null);
        }

        default VisitReasonVo visitReasonVo(String value) {
            return Optional.ofNullable(value).map(VisitReasonVo::from).orElse(null);
        }
    }
}
