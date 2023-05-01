package com.toy.accesscontrol.datacenter.domain.vo;

public record DataCenterName(String value) {
    public static DataCenterName from(String value) {
        return new DataCenterName(value);
    }
}
