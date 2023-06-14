package com.toy.accesscontrol.visit.adapter.out.persistence.entity;

import com.toy.accesscontrol.visit.adapter.out.persistence.entity.embedded.RequesterEntity;
import com.toy.accesscontrol.visit.adapter.out.persistence.entity.embedded.VisitPeriodEntity;
import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.mapper.VisitBaseMapper;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitStatusVo;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Entity(name = "Visit")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Mapstruct 사용 하려면 PUBLIC 사용 해야함.
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder // Mapstruct 사용 하려면 필요
public class VisitEntity {
    @Transient
    public static final VisitEntityMapper MAPPER = VisitEntityMapper.INSTANCE;

    @Id
    @Column(name = "visit_id")
    @Comment("고유 아이디")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private VisitPeriodEntity visitPeriod;

    @Comment("데이터 센터 아이디")
    private Long dataCenterId;

    @Comment("방문 사유")
    private String visitReason;

    @Comment("방문 상태")
    @Enumerated(EnumType.STRING)
    private VisitStatusVo status;

    @Comment("신청자 아이디")
    private String applicantUserId;

    @Embedded
    private RequesterEntity requester;

    @Mapper
    public interface VisitEntityMapper extends VisitBaseMapper {
        VisitEntityMapper INSTANCE = Mappers.getMapper(VisitEntityMapper.class);

        VisitEntity toEntity(VisitDto dto);

        VisitDto toDto(VisitEntity entity);
    }
}
