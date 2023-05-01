package com.toy.accesscontrol.visit.adapter.out.persistence.repository;

import com.toy.accesscontrol.visit.adapter.out.persistence.entity.VisitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitorJpaRepository extends JpaRepository<VisitorEntity, Long> {
    List<VisitorEntity> findAllByVisitId(Long visitId);
}
