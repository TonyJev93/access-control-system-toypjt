package com.toy.accesscontrol.visit.adapter.out.persistence;

import com.toy.accesscontrol.visit.adapter.out.persistence.jpa.VisitJpaRepository;
import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.out.LoadVisitRepositoryPort;
import com.toy.accesscontrol.visit.application.port.out.SaveVisitRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.toy.accesscontrol.visit.adapter.out.persistence.entity.VisitEntity.MAPPER;

@Repository
@RequiredArgsConstructor
public class VisitRepository implements SaveVisitRepositoryPort, LoadVisitRepositoryPort {

    private final VisitJpaRepository repository;

    @Override
    public VisitDto save(VisitDto visitDto) {
        var visitEntity = MAPPER.toEntity(visitDto);

        var saved = repository.save(visitEntity);

        return MAPPER.toDto(saved);
    }

    @Override
    public Optional<VisitDto> findBy(VisitIdVo id) {
        return repository.findById(id.value())
                .map(MAPPER::toDto);
    }
}
