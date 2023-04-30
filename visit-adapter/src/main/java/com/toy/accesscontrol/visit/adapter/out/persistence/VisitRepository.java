package com.toy.accesscontrol.visit.adapter.out.persistence;

import com.toy.accesscontrol.visit.adapter.out.persistence.entity.VisitEntity;
import com.toy.accesscontrol.visit.adapter.out.persistence.repository.VisitJpaRepository;
import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.out.SaveVisitRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class VisitRepository implements SaveVisitRepositoryPort {

    private final VisitJpaRepository repository;

    @Override
    public VisitDto save(VisitDto visit) {
        return repository.save(VisitEntity.from(visit)).toDto();
    }
}
