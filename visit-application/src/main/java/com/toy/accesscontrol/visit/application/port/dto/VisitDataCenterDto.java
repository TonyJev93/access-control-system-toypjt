package com.toy.accesscontrol.visit.application.port.dto;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterNameVo;

public record VisitDataCenterDto(VisitDataCenterIdVo id, VisitDataCenterNameVo name) {
}
