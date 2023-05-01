package com.toy.accesscontrol.visit.domain.vo;

public record VisitReason(String value) {
    public static VisitReason from(String value) {
        return new VisitReason(value);
    }
}
