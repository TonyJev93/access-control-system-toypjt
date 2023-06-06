package com.toy.accesscontrol.visit.application.port.dto;

import com.toy.accesscontrol.visit.application.port.dto.vo.*;
import com.toy.accesscontrol.visit.domain.Visit;

public record VisitDto(
        VisitIdVo id,
        VisitPeriodVo visitPeriod,
        VisitDataCenterIdVo dataCenterId,
        VisitReasonVo visitReason,
        VisitStatusVo status,
        ApplicantUserIdVo applicantUserId,
        RequesterDto requester
) {
    public static VisitDto fromDomain(Visit visit) {
        return new VisitDto(
                visit.getId() == null ? null : VisitIdVo.fromDomain(visit.getId()),
                VisitPeriodVo.fromDomain(visit.getVisitPeriod()),
                VisitDataCenterIdVo.fromDomain(visit.getDataCenterId()),
                VisitReasonVo.fromDomain(visit.getReason()),
                VisitStatusVo.fromDomain(visit.getStatus()),
                ApplicantUserIdVo.fromDomain(visit.getApplicantUserId()),
                RequesterDto.fromDomain(visit.getRequester())
        );
    }

    public Visit toDomain() {
        return Visit.of(
                id.toDomain(),
                visitPeriod.toDomain(),
                dataCenterId.toDomain(),
                visitReason.toDomain(),
                VisitStatusVo.toDomain(status),
                applicantUserId.toDomain(),
                requester.toDomain()
        );
    }
}
