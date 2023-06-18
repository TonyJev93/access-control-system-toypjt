package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.in.VisitGetHistoryUseCase.VisitRevisionDto;

import java.util.List;
import java.util.Optional;

public interface LoadVisitRepositoryPort {
    Optional<VisitDto> findBy(VisitIdVo id);

    List<VisitRevisionDto> findRevisions(VisitIdVo id);
}
