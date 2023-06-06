package com.toy.accesscontrol.visit.application.port.dto.mapper;


import com.toy.accesscontrol.visit.application.port.dto.vo.VisitReasonVo;

import java.util.Optional;

public interface VisitReasonVoMapper {
    default String visitReasonVo(VisitReasonVo value) {
        return Optional.ofNullable(value).map(VisitReasonVo::value).orElse(null);
    }

    default VisitReasonVo visitReasonVo(String value) {
        return Optional.ofNullable(value).map(VisitReasonVo::from).orElse(null);
    }
}
