package com.toy.accesscontrol.datacenter.application.port.dto;

import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterIdVo;
import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterNameVo;
import com.toy.accesscontrol.datacenter.domain.DataCenter;

public record DataCenterDto(
        DataCenterIdVo id,
        DataCenterNameVo name
) {
    public static DataCenterDto fromDomain(DataCenter dataCenter) {
        return new DataCenterDto(
                dataCenter.getId() == null ? null : DataCenterIdVo.fromDomain(dataCenter.getId()),
                DataCenterNameVo.fromDomain(dataCenter.getName())
        );
    }

    public static DataCenterDto of(DataCenterIdVo id, DataCenterNameVo name) {
        return new DataCenterDto(
                id, name
        );
    }
}
