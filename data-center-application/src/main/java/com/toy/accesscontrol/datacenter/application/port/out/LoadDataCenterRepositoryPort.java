package com.toy.accesscontrol.datacenter.application.port.out;

import com.toy.accesscontrol.datacenter.domain.DataCenter;

public interface LoadDataCenterRepositoryPort {
    DataCenter save(DataCenter dataCenter);
}
