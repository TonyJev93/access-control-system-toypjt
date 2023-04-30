package com.toy.accesscontrol.datacenter.application.service;

import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.in.DataCenterCreateUseCase;
import com.toy.accesscontrol.datacenter.application.port.out.SaveDataCenterRepositoryPort;
import com.toy.accesscontrol.datacenter.domain.DataCenter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataCenterCreateService implements DataCenterCreateUseCase {

    private final SaveDataCenterRepositoryPort saveDataCenterRepositoryPort;

    @Override
    public DataCenterDto create(DataCenterCreateRequestDto request) {
        var dataCenter = DataCenter.create(request.name().toDomain());

        return saveDataCenterRepositoryPort.save(
                DataCenterDto.fromDomain(dataCenter)
        );
    }
}
