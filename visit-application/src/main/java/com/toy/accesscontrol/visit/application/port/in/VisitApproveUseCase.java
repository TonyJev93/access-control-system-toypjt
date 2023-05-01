package com.toy.accesscontrol.visit.application.port.in;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.ApplicantUserIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitPeriodVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitReasonVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface VisitApproveUseCase {
    VisitDto visitApprove(@Valid @NotNull VisitApproveRequestDto request);

    record VisitApproveRequestDto(
            @Valid @NotNull VisitPeriodVo visitPeriod,
            @Valid @NotNull VisitDataCenterIdVo dataCenterId,
            @Valid @NotNull VisitReasonVo reason,
            @Valid @NotNull ApplicantUserIdVo applicantUserId
    ) {
    }
}
