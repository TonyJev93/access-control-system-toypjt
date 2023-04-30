package com.toy.accesscontrol.visit.application.service;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.in.VisitApplyUseCase;
import com.toy.accesscontrol.visit.application.port.out.LoadDataCenterRepository;
import com.toy.accesscontrol.visit.application.port.out.LoadUserRepository;
import com.toy.accesscontrol.visit.application.port.out.SaveVisitRepositoryPort;
import com.toy.accesscontrol.visit.domain.Visit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitApplyService implements VisitApplyUseCase {

    private final SaveVisitRepositoryPort saveVisitRepositoryPort;
    private final LoadDataCenterRepository loadDataCenterRepository;
    private final LoadUserRepository loadUserRepository;

    private static VisitDto appliedVisitDto(VisitApplyRequestDto dto) {
        return VisitDto.from(
                Visit.applied(
                        dto.visitPeriod().toDomain(),
                        dto.dataCenterId().toDomain(),
                        dto.reason().toDomain(),
                        dto.applicantUserId().toDomain()
                )
        );
    }

    @Override
    public VisitDto visitApply(VisitApplyRequestDto request) {
        if (!loadDataCenterRepository.isDataCenterExist(request.dataCenterId())) {
            throw new RuntimeException("존재하지 않는 데이터 센터입니다.");
        }

        if (!loadUserRepository.isUserExist(request.applicantUserId())) {
            throw new RuntimeException("존재하지 않는 사용자 입니다.");
        }

        return saveVisitRepositoryPort.save(appliedVisitDto(request));
    }
}
