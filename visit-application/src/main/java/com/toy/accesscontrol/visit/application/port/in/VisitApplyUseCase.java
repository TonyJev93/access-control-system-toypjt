package com.toy.accesscontrol.visit.application.port.in;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface VisitApplyUseCase {
    VisitDto visitApply(@Valid @NotNull VisitApplyRequestDto request);

    record VisitApplyRequestDto(
            @Valid @NotNull VisitPeriodVo visitPeriod,
            @Valid @NotNull VisitDataCenterIdVo dataCenterId,
            @Valid @NotNull VisitReasonVo reason,
            @Valid @NotNull ApplicantUserIdVo applicantUserId,
            @Valid @NotNull List<VisitorCreateRequestDto> visitors
    ) {
        public record VisitorCreateRequestDto(
                VisitorIdVo id,
                VisitorNameVo name,
                MobilePhoneNumberVo mobilePhoneNumber,
                CompanyVo company
        ) {
        }
    }
}
