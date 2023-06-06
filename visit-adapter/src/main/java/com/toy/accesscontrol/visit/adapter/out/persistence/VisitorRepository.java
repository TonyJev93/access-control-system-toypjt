package com.toy.accesscontrol.visit.adapter.out.persistence;

import com.toy.accesscontrol.visit.adapter.out.persistence.jpa.VisitorJpaRepository;
import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.out.LoadVisitorRepositoryPort;
import com.toy.accesscontrol.visit.application.port.out.SaveVisitorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.toy.accesscontrol.visit.adapter.out.persistence.entity.VisitorEntity.MAPPER;

@Repository
@RequiredArgsConstructor
@Transactional
public class VisitorRepository implements SaveVisitorRepositoryPort, LoadVisitorRepositoryPort {

    private final VisitorJpaRepository repository;

    @Override
    public VisitorDto save(VisitorDto visitor) {
        return MAPPER.toDto(
                repository.save(
                        MAPPER.toEntity(visitor)
                )
        );
    }

    @Override
    // [Study] Transactional 이 없으면 LazyLoading 시 Session 을 찾을 수 없다는 에러 발생
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<VisitorDto> findAllByVisitId(VisitIdVo visitId) {
        return repository.findAllByVisitId(visitId.value())
                .stream()
                .map(MAPPER::toDto)
                .toList();
    }

}
