package com.toy.accesscontrol.visit.domain.vo;

public record VisitId(Long value) {
    public static VisitId from(Long value) {
        return new VisitId(value);
    }
}
