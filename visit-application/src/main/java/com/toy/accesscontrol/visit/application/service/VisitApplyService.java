package com.toy.accesscontrol.visit.application.service;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.in.VisitApplyUseCase;
import com.toy.accesscontrol.visit.application.port.out.*;
import com.toy.accesscontrol.visit.domain.Visit;
import com.toy.accesscontrol.visit.domain.Visitor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitApplyService implements VisitApplyUseCase {

    private final SaveVisitRepositoryPort saveVisitRepositoryPort;
    private final LoadDataCenterRepository loadDataCenterRepository;
    private final LoadUserRepository loadUserRepository;
    private final SaveVisitorRepositoryPort saveVisitorRepositoryPort;
    private final VisitAppliedEventPublisher visitAppliedEventPublisher;

    private static Visit appliedVisitByRequest(VisitApplyRequestDto dto) {
        return Visit.applied(
                dto.visitPeriod().toDomain(),
                dto.dataCenterId().toDomain(),
                dto.reason().toDomain(),
                dto.applicantUserId().toDomain()
        );
    }

    private static List<Visitor> visitorsByRequest(VisitApplyRequestDto request, VisitIdVo visitId) {
        return request.visitors().stream()
                .map(visitor ->
                        Visitor.create(
                                visitId.toDomain(),
                                visitor.name().toDomain(),
                                visitor.mobilePhoneNumber().toDomain(),
                                visitor.company().toDomain()
                        )
                ).toList();
    }

    @Override
    @Transactional
    public VisitDto visitApply(VisitApplyRequestDto request) {
        throwIfInvalidRequest(request);

        var appliedVisit = saveVisitRepositoryPort.save(
                VisitDto.from(appliedVisitByRequest(request))
        );

        saveVisitors(request, appliedVisit.id());

        visitAppliedEventPublisher.publish(appliedVisit.id());

        return appliedVisit;
    }

    private List<VisitorDto> saveVisitors(VisitApplyRequestDto request, VisitIdVo visitId) {
        return visitorsByRequest(request, visitId).stream()
                .map(visitor -> saveVisitorRepositoryPort.save(VisitorDto.fromDomain(visitor)))
                .toList();
    }

    private void throwIfInvalidRequest(VisitApplyRequestDto request) {
        if (!loadDataCenterRepository.isDataCenterExist(request.dataCenterId())) {
            throw new RuntimeException("존재하지 않는 데이터 센터입니다.");
        }

        if (!loadUserRepository.isUserExist(request.applicantUserId())) {
            throw new RuntimeException("존재하지 않는 사용자 입니다.");
        }
    }
}
