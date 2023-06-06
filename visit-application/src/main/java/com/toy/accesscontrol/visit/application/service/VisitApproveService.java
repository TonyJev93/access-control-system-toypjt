package com.toy.accesscontrol.visit.application.service;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.exception.VisitNotFoundException;
import com.toy.accesscontrol.visit.application.port.in.VisitApproveUseCase;
import com.toy.accesscontrol.visit.application.port.out.LoadVisitRepositoryPort;
import com.toy.accesscontrol.visit.application.port.out.SaveVisitRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitApproveService implements VisitApproveUseCase {

    private final SaveVisitRepositoryPort saveVisitRepositoryPort;
    private final LoadVisitRepositoryPort loadVisitRepositoryPort;

    @Override
    public VisitDto visitApprove(VisitIdVo id) {
        var visit = loadVisitRepositoryPort.findBy(id)
                .orElseThrow(() -> new VisitNotFoundException(id))
                .toDomain();

        visit.approve();

        return saveVisitRepositoryPort.save(VisitDto.fromDomain(visit));
    }
}
