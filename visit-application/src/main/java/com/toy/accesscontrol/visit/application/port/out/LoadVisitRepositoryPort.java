package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;

import java.util.Optional;

public interface LoadVisitRepositoryPort {
    Optional<VisitDto> findBy(VisitIdVo id);
}
