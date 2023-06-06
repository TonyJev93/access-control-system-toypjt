package com.toy.accesscontrol.visit.application.port.dto.mapper;


import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;

import java.util.Optional;

public interface VisitDataCenterIdVoMapper {
    default Long visitDataCenterIdVo(VisitDataCenterIdVo id) {
        return Optional.ofNullable(id).map(VisitDataCenterIdVo::value).orElse(null);
    }

    default VisitDataCenterIdVo visitDataCenterIdVo(Long id) {
        return Optional.ofNullable(id).map(VisitDataCenterIdVo::from).orElse(null);
    }
}
