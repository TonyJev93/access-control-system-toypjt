package com.toy.accesscontrol.datacenter.adapter.in.dto;

import com.toy.accesscontrol.datacenter.domain.DataCenter;
import com.toy.accesscontrol.datacenter.domain.vo.DataCenterName;

public record DataCenterDto(
        Long id,
        DataCenterName name
) {
    public static DataCenterDto from(DataCenter dataCenter) {
        return new DataCenterDto(
                dataCenter.getId(),
                dataCenter.getName()
        );
    }
}
