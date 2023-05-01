package com.toy.accesscontrol.visit.domain.vo;

public record VisitDataCenterId(Long value) {
    public static VisitDataCenterId from(Long value) {
        return new VisitDataCenterId(value);
    }
}
