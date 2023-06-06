package com.toy.accesscontrol.visit.application.port.dto.mapper;


import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;

import java.util.Optional;

public interface VisitIdVoMapper {
    default Long visitIdVo(VisitIdVo id) {
        return Optional.ofNullable(id).map(VisitIdVo::value).orElse(null);
    }

    default VisitIdVo visitIdVo(Long id) {
        return Optional.ofNullable(id).map(VisitIdVo::from).orElse(null);
    }
}
