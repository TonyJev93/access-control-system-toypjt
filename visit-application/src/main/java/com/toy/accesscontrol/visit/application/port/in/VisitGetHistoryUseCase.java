package com.toy.accesscontrol.visit.application.port.in;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface VisitGetHistoryUseCase {
    List<VisitRevisionDto> getHistories(VisitIdVo visitId);

    record VisitRevisionDto(
            Integer revisionNumber,
            @JsonUnwrapped VisitDto visit
    ) {
    }
}
