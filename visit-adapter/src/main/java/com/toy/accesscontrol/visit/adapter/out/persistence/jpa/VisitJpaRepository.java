package com.toy.accesscontrol.visit.adapter.out.persistence.jpa;

import com.toy.accesscontrol.visit.adapter.out.persistence.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitJpaRepository extends JpaRepository<VisitEntity, Long> {
}
