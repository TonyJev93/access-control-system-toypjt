package com.toy.accesscontrol.user.domain.vo;

public record UserId(String value) {
    public static UserId from(String value) {
        return new UserId(value);
    }
}
