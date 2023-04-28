package com.toy.accesscontrol.datacenter.adapter.in.dto;

import com.toy.accesscontrol.datacenter.application.port.in.DataCenterCreateUseCase.DataCenterCreateRequest;
import com.toy.accesscontrol.datacenter.domain.vo.DataCenterName;

public record DataCenterCreateRequestDto(
        DataCenterName name
) {
    public DataCenterCreateRequest toPortRequest() {
        return new DataCenterCreateRequest(name);
    }
}
