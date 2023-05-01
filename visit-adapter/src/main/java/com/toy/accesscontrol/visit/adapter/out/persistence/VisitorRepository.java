package com.toy.accesscontrol.visit.adapter.out.persistence;

import com.toy.accesscontrol.visit.adapter.out.persistence.entity.VisitorEntity;
import com.toy.accesscontrol.visit.adapter.out.persistence.repository.VisitorJpaRepository;
import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.out.LoadVisitorRepositoryPort;
import com.toy.accesscontrol.visit.application.port.out.SaveVisitorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VisitorRepository implements SaveVisitorRepositoryPort, LoadVisitorRepositoryPort {

    private final VisitorJpaRepository repository;

    @Override
    public VisitorDto save(VisitorDto visit) {
        return repository.save(VisitorEntity.from(visit))
                .toDto();
    }

    @Override
    public List<VisitorDto> findAllByVisitId(VisitIdVo visitId) {
        return repository.findAllByVisitId(visitId.value())
                .stream()
                .map(VisitorEntity::toDto)
                .toList();
    }

}
