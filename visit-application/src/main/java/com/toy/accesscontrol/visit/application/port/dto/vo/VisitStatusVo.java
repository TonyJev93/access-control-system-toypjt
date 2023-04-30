package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.toy.accesscontrol.visit.domain.vo.VisitStatus;

public enum VisitStatusVo {
    APPLIED, APPROVED, REJECTED, CANCELED;

    public static VisitStatusVo from(String value) {
        return VisitStatusVo.valueOf(value);
    }

    public static VisitStatusVo fromDomain(VisitStatus domain) {
        return VisitStatusVo.from(domain.name());
    }

    public static VisitStatus toDomain(VisitStatusVo apiVo) {
        return VisitStatus.valueOf(apiVo.name());
    }
}
