package com.toy.accesscontrol.visit.adapter.out.persistence.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.accesscontrol.visit.adapter.out.persistence.entity.QVisitEntity;
import com.toy.accesscontrol.visit.adapter.out.persistence.entity.VisitEntity;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class VisitJpaRepositoryImpl extends QuerydslRepositorySupport implements VisitJpaRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public VisitJpaRepositoryImpl(JPAQueryFactory queryFactory) {
        super(VisitEntity.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<VisitEntity> findByQueryDsl(Long id) {
        return queryFactory
                .selectFrom(QVisitEntity.visitEntity)
                .fetch();
    }

    @Override
    public List findRevisionsWithQueryDsl(Long id) {
        var auditReader = AuditReaderFactory.get(getEntityManager());

        /**
         * forRevisionsOfEntityWithChanges (@Incubating : 아직 실험 단계...)
         * - [0] : Entity
         * - [1] : RevisionEntity
         * - [2] : RevisionType
         * - [3] : HashSet <- Changed Properties
         */
        var auditQuery = auditReader.createQuery()
                .forRevisionsOfEntityWithChanges(VisitEntity.class, true);

        return auditQuery.getResultList();
    }
}
