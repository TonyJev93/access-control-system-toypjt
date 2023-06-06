package com.toy.accesscontrol.visit.application.service;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;
import com.toy.accesscontrol.visit.application.port.exception.ApplicantUserNotFoundException;
import com.toy.accesscontrol.visit.application.port.exception.VisitDataCenterNotFoundException;
import com.toy.accesscontrol.visit.application.port.in.VisitApplyUseCase;
import com.toy.accesscontrol.visit.application.port.out.*;
import com.toy.accesscontrol.visit.domain.Visit;
import com.toy.accesscontrol.visit.domain.Visitor;
import com.toy.accesscontrol.visit.domain.Visitors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VisitApplyService implements VisitApplyUseCase {

    private final SaveVisitRepositoryPort saveVisitRepositoryPort;
    private final LoadDataCenterRepositoryPort loadDataCenterRepositoryPort;
    private final LoadUserRepositoryPort loadUserRepositoryPort;
    private final SaveVisitorRepositoryPort saveVisitorRepositoryPort;
    private final VisitAppliedEventPublisher visitAppliedEventPublisher;

    private static Visit appliedVisitByRequest(VisitApplyRequestDto request) {
        return Visit.applied(
                request.visitPeriod().toDomain(),
                request.dataCenterId().toDomain(),
                request.visitReason().toDomain(),
                request.applicantUserId().toDomain(),
                request.requester().toDomain()
        );
    }

    private static Visitors visitorsByRequest(VisitApplyRequestDto request, VisitDto visitDto) {
        var visitors =
                request.visitors()
                        .stream()
                        .map(visitor ->
                                Visitor.create(
                                        visitDto.toDomain(),
                                        visitor.name().toDomain(),
                                        visitor.mobilePhoneNumber().toDomain(),
                                        visitor.company().toDomain()
                                )
                        ).toList();

        return Visitors.from(visitors);
    }

    @Override
    @Transactional
    public VisitDto visitApply(VisitApplyRequestDto request) {
        throwIfInvalidRequest(request);

        var appliedVisitDto = saveVisitRepositoryPort.save(
                VisitDto.fromDomain(appliedVisitByRequest(request))
        );

        saveVisitors(request, appliedVisitDto);

        visitAppliedEventPublisher.publish(appliedVisitDto.id());

        return appliedVisitDto;
    }

    private void saveVisitors(VisitApplyRequestDto request, VisitDto visitDto) {
        var visitors = visitorsByRequest(request, visitDto);

        visitors.getValues()
                .forEach(
                        visitor ->
                                saveVisitorRepositoryPort.save(
                                        VisitorDto.fromDomain(visitor)
                                )
                );
    }

    private void throwIfInvalidRequest(VisitApplyRequestDto request) {
        if (!loadDataCenterRepositoryPort.isDataCenterExist(request.dataCenterId())) {
            throw new VisitDataCenterNotFoundException(request.dataCenterId());
        }

        if (!loadUserRepositoryPort.isUserExist(request.applicantUserId())) {
            throw new ApplicantUserNotFoundException(request.applicantUserId());
        }
    }
}
