package com.toy.accesscontrol.datacenter.application.service;

import com.toy.accesscontrol.datacenter.application.port.in.DataCenterCreateUseCase;
import com.toy.accesscontrol.datacenter.application.port.out.LoadDataCenterRepositoryPort;
import com.toy.accesscontrol.datacenter.domain.DataCenter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataCenterCreateService implements DataCenterCreateUseCase {

    private final LoadDataCenterRepositoryPort loadDataCenterRepositoryPort;

    @Override
    public DataCenter create(DataCenterCreateRequest request) {
        return loadDataCenterRepositoryPort.save(DataCenter.create(request.name()));
    }
}
