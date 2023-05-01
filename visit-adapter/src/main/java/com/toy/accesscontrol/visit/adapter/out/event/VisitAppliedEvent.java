package com.toy.accesscontrol.visit.adapter.out.event;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;

public record VisitAppliedEvent(
        VisitIdVo visitId
) {
}
