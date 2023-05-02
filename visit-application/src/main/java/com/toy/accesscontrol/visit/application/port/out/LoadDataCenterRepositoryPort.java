package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.VisitDataCenterDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;

import java.util.Optional;

public interface LoadDataCenterRepositoryPort {
    boolean isDataCenterExist(VisitDataCenterIdVo id);

    Optional<VisitDataCenterDto> findBy(VisitDataCenterIdVo id);
}
