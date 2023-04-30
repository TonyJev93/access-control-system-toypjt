package com.toy.accesscontrol.datacenter.application.service;

import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterIdVo;
import com.toy.accesscontrol.datacenter.application.port.in.DataCenterRetrieveUseCase;
import com.toy.accesscontrol.datacenter.application.port.out.LoadDataCenterRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DataCenterRetrieveService implements DataCenterRetrieveUseCase {

    private final LoadDataCenterRepositoryPort loadDataCenterRepositoryPort;

    @Override
    public Optional<DataCenterDto> get(DataCenterIdVo id) {
        return loadDataCenterRepositoryPort.findBy(id);
    }
}
