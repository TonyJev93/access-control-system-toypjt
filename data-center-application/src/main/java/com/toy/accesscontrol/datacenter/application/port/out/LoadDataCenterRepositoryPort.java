package com.toy.accesscontrol.datacenter.application.port.out;

import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterIdVo;

import java.util.Optional;

public interface LoadDataCenterRepositoryPort {
    Optional<DataCenterDto> findBy(DataCenterIdVo id);
}
