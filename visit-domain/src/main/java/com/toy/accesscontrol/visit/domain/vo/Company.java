package com.toy.accesscontrol.visit.domain.vo;

public record Company(String value) {
    public static Company from(String value) {
        return new Company(value);
    }
}
