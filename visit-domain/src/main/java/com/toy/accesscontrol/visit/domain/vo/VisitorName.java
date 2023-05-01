package com.toy.accesscontrol.visit.domain.vo;

public record VisitorName(String value) {
    public static VisitorName from(String value) {
        return new VisitorName(value);
    }
}
