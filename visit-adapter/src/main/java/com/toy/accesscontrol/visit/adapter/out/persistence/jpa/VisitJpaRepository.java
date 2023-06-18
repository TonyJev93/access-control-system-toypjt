package com.toy.accesscontrol.visit.adapter.out.persistence.jpa;

import com.toy.accesscontrol.visit.adapter.out.persistence.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface VisitJpaRepository extends
        RevisionRepository<VisitEntity, Long, Integer>,
        JpaRepository<VisitEntity, Long> {
}
