package com.toy.accesscontrol.datacenter.application.port.in;

import com.toy.accesscontrol.datacenter.domain.DataCenter;
import com.toy.accesscontrol.datacenter.domain.vo.DataCenterName;

public interface DataCenterCreateUseCase {
    DataCenter create(DataCenterCreateRequest request);

    record DataCenterCreateRequest(DataCenterName name) {
    }
}
