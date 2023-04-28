package com.toy.accesscontrol.datacenter.adapter.out.persistence;

import com.toy.accesscontrol.datacenter.adapter.out.persistence.entity.DataCenterEntity;
import com.toy.accesscontrol.datacenter.application.port.out.LoadDataCenterRepositoryPort;
import com.toy.accesscontrol.datacenter.domain.DataCenter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DataCenterRepository implements LoadDataCenterRepositoryPort {

    private final DataCenterJpaRepository repository;

    @Override
    public DataCenter save(DataCenter dataCenter) {
        return repository.save(DataCenterEntity.from(dataCenter)).toDomain();
    }
}
