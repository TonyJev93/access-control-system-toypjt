package com.toy.accesscontrol.visit.adapter.out.persistence.jpa;

import com.toy.accesscontrol.visit.adapter.out.persistence.entity.VisitEntity;

import java.util.List;

public interface VisitJpaRepositoryCustom {
    List<VisitEntity> findByQueryDsl(Long id);

    List findRevisionsWithQueryDsl(Long id);
}
