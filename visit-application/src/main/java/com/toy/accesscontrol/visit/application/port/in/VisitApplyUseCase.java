package com.toy.accesscontrol.visit.application.port.in;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.ApplicantUserIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitPeriodVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitReasonVo;

public interface VisitApplyUseCase {
    VisitDto visitApply(VisitApplyRequestDto request);

    record VisitApplyRequestDto(
            VisitPeriodVo visitPeriod,
            VisitDataCenterIdVo dataCenterId,
            VisitReasonVo reason,
            ApplicantUserIdVo applicantUserId
    ) {
    }
}
