package com.toy.accesscontrol.visit.domain.vo;

public record ApplicantUserId(String value) {
    public static ApplicantUserId from(String value) {
        return new ApplicantUserId(value);
    }
}
