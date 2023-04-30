package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;

public interface LoadDataCenterRepository {
    boolean isDataCenterExist(VisitDataCenterIdVo id);
}
