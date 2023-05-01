package com.toy.accesscontrol.visit.domain.vo;

public record MobilePhoneNumber(String value) {
    public static MobilePhoneNumber from(String value) {
        return new MobilePhoneNumber(value);
    }
}
