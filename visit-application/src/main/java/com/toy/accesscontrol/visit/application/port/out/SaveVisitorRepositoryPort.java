package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;

public interface SaveVisitorRepositoryPort {
    VisitorDto save(VisitorDto visit);
}
