package com.toy.accesscontrol.visit.application.port.in;

import com.toy.accesscontrol.visit.application.port.dto.VisitDataCenterDto;
import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import org.springframework.validation.annotation.Validated;

@Validated
public interface VisitGetDetailUseCase {
    VisitDetailView getDetail(VisitIdVo visitId);

    record VisitDetailView(
            VisitDto visit,
            VisitDataCenterDto visitLocation
    ) {
    }
}
