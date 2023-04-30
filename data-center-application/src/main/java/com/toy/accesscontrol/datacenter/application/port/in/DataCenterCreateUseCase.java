package com.toy.accesscontrol.datacenter.application.port.in;

import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterNameVo;
import jakarta.validation.Valid;
import lombok.NonNull;

public interface DataCenterCreateUseCase {
    DataCenterDto create(DataCenterCreateRequestDto request);

    record DataCenterCreateRequestDto(@Valid @NonNull DataCenterNameVo name) {
    }
}
