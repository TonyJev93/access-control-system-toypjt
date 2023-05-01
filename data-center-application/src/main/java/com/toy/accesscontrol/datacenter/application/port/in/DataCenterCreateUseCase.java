package com.toy.accesscontrol.datacenter.application.port.in;

import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterNameVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface DataCenterCreateUseCase {
    DataCenterDto create(@Valid @NotNull DataCenterCreateRequestDto request);

    record DataCenterCreateRequestDto(@Valid @NotNull DataCenterNameVo name) {
    }
}
