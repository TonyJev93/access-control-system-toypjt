package com.toy.accesscontrol.visit.domain.vo;

public record VisitorId(Long value) {
    public static VisitorId from(Long value) {
        return new VisitorId(value);
    }
}
