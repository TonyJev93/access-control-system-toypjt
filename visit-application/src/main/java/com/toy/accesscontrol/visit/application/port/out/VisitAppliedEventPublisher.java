package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;

public interface VisitAppliedEventPublisher {
    void publish(VisitIdVo visitId);
}
