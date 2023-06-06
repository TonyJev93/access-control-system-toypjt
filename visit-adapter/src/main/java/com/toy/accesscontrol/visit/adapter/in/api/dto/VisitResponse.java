package com.toy.accesscontrol.visit.adapter.in.api.dto;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.*;

import java.time.ZonedDateTime;

public record VisitResponse(
        VisitIdVo id,
        ZonedDateTime visitStartDateTime,
        ZonedDateTime visitEndDateTime,
        VisitDataCenterIdVo dataCenterId,
        VisitReasonVo reason,
        VisitStatusVo status,
        ApplicantUserIdVo applicantUserId
) {

    public static VisitResponse from(VisitDto dto) {
        return new VisitResponse(
                dto.id(),
                dto.visitPeriod().startDateTime(),
                dto.visitPeriod().endDateTime(),
                dto.dataCenterId(),
                dto.visitReason(),
                dto.status(),
                dto.applicantUserId()
        );
    }
}
