package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;

import java.util.List;

public interface LoadVisitorRepositoryPort {
    List<VisitorDto> findAllByVisitId(VisitIdVo visitId);
}
