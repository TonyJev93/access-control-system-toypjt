package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;

public interface SaveVisitRepositoryPort {
    VisitDto save(VisitDto visit);
}
