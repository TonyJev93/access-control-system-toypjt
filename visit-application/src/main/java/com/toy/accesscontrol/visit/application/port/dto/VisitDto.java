package com.toy.accesscontrol.visit.application.port.dto;

import com.toy.accesscontrol.visit.application.port.dto.vo.ApplicantUserIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitReasonVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitStatusVo;
import com.toy.accesscontrol.visit.domain.Visit;

import java.time.ZonedDateTime;

public record VisitDto(
        Long id,
        ZonedDateTime visitStartDateTime,
        ZonedDateTime visitEndDateTime,
        VisitDataCenterIdVo dataCenterId,
        VisitReasonVo reason,
        VisitStatusVo status,
        ApplicantUserIdVo applicantUserId
) {
    public static VisitDto from(Visit visit) {
        return new VisitDto(
                visit.getId(),
                visit.getVisitPeriod().startDateTime(),
                visit.getVisitPeriod().endDateTime(),
                VisitDataCenterIdVo.fromDomain(visit.getDataCenterId()),
                VisitReasonVo.fromDomain(visit.getReason()),
                VisitStatusVo.fromDomain(visit.getStatus()),
                ApplicantUserIdVo.fromDomain(visit.getApplicantUserId())
        );
    }
}
