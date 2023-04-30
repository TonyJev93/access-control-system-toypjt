package com.toy.accesscontrol.visit.adapter.in;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.ApplicantUserIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitPeriodVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitReasonVo;
import com.toy.accesscontrol.visit.application.port.in.VisitApplyUseCase;
import com.toy.accesscontrol.visit.application.port.in.VisitApplyUseCase.VisitApplyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@Validated
@RequestMapping("/api/v1/visit")
@RequiredArgsConstructor
public class VisitApplyController {

    private final VisitApplyUseCase visitApplyUseCase;

    @PostMapping("/apply")
    public VisitDto visitApply(@RequestBody VisitApplyRequest request) {
        return visitApplyUseCase.visitApply(request.toDto());
    }

    private record VisitApplyRequest(
            ZonedDateTime visitStartDateTime,
            ZonedDateTime visitEndDateTime,
            VisitDataCenterIdVo dataCenterId,
            VisitReasonVo reason,
            ApplicantUserIdVo applicantUserId
    ) {

        public VisitApplyRequestDto toDto() {
            return new VisitApplyRequestDto(
                    VisitPeriodVo.of(visitStartDateTime, visitEndDateTime),
                    dataCenterId,
                    reason,
                    applicantUserId
            );
        }
    }
}