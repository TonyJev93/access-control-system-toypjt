package com.toy.accesscontrol.datacenter.adapter.out.persistence;

import com.toy.accesscontrol.datacenter.adapter.out.persistence.entity.DataCenterEntity;
import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterIdVo;
import com.toy.accesscontrol.datacenter.application.port.out.LoadDataCenterRepositoryPort;
import com.toy.accesscontrol.datacenter.application.port.out.SaveDataCenterRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DataCenterRepository implements SaveDataCenterRepositoryPort, LoadDataCenterRepositoryPort {

    private final DataCenterJpaRepository repository;

    @Override
    public DataCenterDto save(DataCenterDto dto) {
        var entity = DataCenterEntity.from(dto);
        return repository.save(entity).toDto();
    }

    @Override
    public Optional<DataCenterDto> findBy(DataCenterIdVo id) {
        return repository.findById(id.value())
                .map(DataCenterEntity::toDto);
    }
}