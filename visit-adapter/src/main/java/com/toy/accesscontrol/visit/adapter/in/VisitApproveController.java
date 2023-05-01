package com.toy.accesscontrol.visit.adapter.in;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.ApplicantUserIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitPeriodVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitReasonVo;
import com.toy.accesscontrol.visit.application.port.in.VisitApproveUseCase;
import com.toy.accesscontrol.visit.application.port.in.VisitApproveUseCase.VisitApproveRequestDto;
import jakarta.validation.Valid;
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
public class VisitApproveController {

    private final VisitApproveUseCase visitApproveUseCase;

    @PostMapping("/approve")
    public VisitDto visitApply(@Valid @RequestBody VisitApproveRequest request) {
        return visitApproveUseCase.visitApprove(request.toDto());
    }

    private record VisitApproveRequest(
            ZonedDateTime visitStartDateTime,
            ZonedDateTime visitEndDateTime,
            VisitDataCenterIdVo dataCenterId,
            VisitReasonVo reason,
            ApplicantUserIdVo applicantUserId
    ) {

        public VisitApproveRequestDto toDto() {
            return new VisitApproveRequestDto(
                    VisitPeriodVo.of(visitStartDateTime, visitEndDateTime),
                    dataCenterId,
                    reason,
                    applicantUserId
            );
        }
    }
}