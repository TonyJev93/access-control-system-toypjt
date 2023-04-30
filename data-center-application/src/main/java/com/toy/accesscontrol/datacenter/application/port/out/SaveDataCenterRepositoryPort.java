package com.toy.accesscontrol.datacenter.application.port.out;

import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;

public interface SaveDataCenterRepositoryPort {
    DataCenterDto save(DataCenterDto dto);
}
