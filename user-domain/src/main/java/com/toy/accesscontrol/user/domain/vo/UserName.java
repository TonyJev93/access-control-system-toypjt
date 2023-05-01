package com.toy.accesscontrol.user.domain.vo;

public record UserName(String value) {
    public static UserName from(String value) {
        return new UserName(value);
    }
}
