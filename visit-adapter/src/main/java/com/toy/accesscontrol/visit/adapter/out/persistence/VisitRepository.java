package com.toy.accesscontrol.visit.adapter.out.persistence;

import com.toy.accesscontrol.visit.adapter.out.persistence.mapper.VisitEntityMapper;
import com.toy.accesscontrol.visit.adapter.out.persistence.repository.VisitJpaRepository;
import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.out.LoadVisitRepositoryPort;
import com.toy.accesscontrol.visit.application.port.out.SaveVisitRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VisitRepository implements SaveVisitRepositoryPort, LoadVisitRepositoryPort {

    private final VisitJpaRepository repository;
    private final VisitEntityMapper mapper;

    @Override
    public VisitDto save(VisitDto visitDto) {
        var visitEntity = mapper.toEntity(visitDto);

        var saved = repository.save(visitEntity);

        return mapper.toDto(saved);
    }

    @Override
    public Optional<VisitDto> findBy(VisitIdVo id) {
        return repository.findById(id.value())
                .map(mapper::toDto);
    }
}
