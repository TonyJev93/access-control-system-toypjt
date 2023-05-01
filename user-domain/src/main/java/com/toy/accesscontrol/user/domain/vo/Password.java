package com.toy.accesscontrol.user.domain.vo;

public record Password(String value) {
    public static Password from(String value) {
        return new Password(value);
    }
}
