package com.toy.accesscontrol.datacenter.application.port.in;

import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterIdVo;

import java.util.Optional;

public interface DataCenterRetrieveUseCase {
    Optional<DataCenterDto> get(DataCenterIdVo id);
}
