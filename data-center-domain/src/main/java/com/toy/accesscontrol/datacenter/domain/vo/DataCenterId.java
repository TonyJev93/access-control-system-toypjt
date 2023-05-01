package com.toy.accesscontrol.datacenter.domain.vo;

public record DataCenterId(Long value) {
    public static DataCenterId from(Long value) {
        return new DataCenterId(value);
    }
}
