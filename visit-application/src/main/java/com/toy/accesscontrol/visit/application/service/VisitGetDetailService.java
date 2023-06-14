package com.toy.accesscontrol.visit.application.service;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.exception.VisitDataCenterNotFoundException;
import com.toy.accesscontrol.visit.application.port.exception.VisitNotFoundException;
import com.toy.accesscontrol.visit.application.port.in.VisitGetDetailUseCase;
import com.toy.accesscontrol.visit.application.port.out.LoadDataCenterRepositoryPort;
import com.toy.accesscontrol.visit.application.port.out.LoadVisitRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitGetDetailService implements VisitGetDetailUseCase {

    private final LoadVisitRepositoryPort loadVisitRepositoryPort;
    private final LoadDataCenterRepositoryPort loadDataCenterRepositoryPort;

    @Override
    public VisitDetailView getDetail(VisitIdVo visitId) {
        var visit = loadVisitRepositoryPort.findBy(visitId)
                .orElseThrow(() -> new VisitNotFoundException(visitId));

        var visitDataCenter = loadDataCenterRepositoryPort.findBy(visit.dataCenterId())
                .orElseThrow(() -> new VisitDataCenterNotFoundException(visit.dataCenterId()));
        
        return new VisitDetailView(visit, visitDataCenter);
    }
}
