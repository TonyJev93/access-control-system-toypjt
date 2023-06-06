package com.toy.accesscontrol.visit.domain.vo;

public record EmailAddress(String value) {
    public static EmailAddress from(String value) {
        return new EmailAddress(value);
    }
}
