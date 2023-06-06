package com.toy.accesscontrol.visit.domain.vo;

public record RequesterName(String value) {
    public static RequesterName from(String value) {
        return new RequesterName(value);
    }
}
