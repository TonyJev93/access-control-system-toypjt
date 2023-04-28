package com.toy.accesscontrol.datacenter.adapter.out.persistence;

import com.toy.accesscontrol.datacenter.adapter.out.persistence.entity.DataCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataCenterJpaRepository extends JpaRepository<DataCenterEntity, Long> {
}
