package com.toy.accesscontrol.visit.application.service;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.in.VisitGetHistoryUseCase;
import com.toy.accesscontrol.visit.application.port.out.LoadVisitRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitGetHistoryService implements VisitGetHistoryUseCase {

    private final LoadVisitRepositoryPort loadVisitRepositoryPort;

    @Override
    public List<VisitRevisionDto> getHistories(VisitIdVo visitId) {
        return loadVisitRepositoryPort.findRevisions(visitId);
    }
}
