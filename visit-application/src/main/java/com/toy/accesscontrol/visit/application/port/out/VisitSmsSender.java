package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.VisitDataCenterDto;
import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;

public interface VisitSmsSender {
    void sendVisitAppliedSms(VisitAppliedSmsSendRequest request);

    record VisitAppliedSmsSendRequest(
            VisitDataCenterDto visitDataCenter,
            VisitorDto visitor
    ) {

    }
}
