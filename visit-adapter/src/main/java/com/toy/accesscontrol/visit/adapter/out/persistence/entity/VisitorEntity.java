package com.toy.accesscontrol.visit.adapter.out.persistence.entity;

import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;
import com.toy.accesscontrol.visit.application.port.dto.mapper.VisitDtoMapper;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Entity(name = "Visitor")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder // Mapstruct 사용 하려면 필요
public class VisitorEntity {
    public static final VisitorEntityMapper MAPPER = VisitorEntityMapper.INSTANCE;

    @Id
    @Comment("고유 아이디")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_id")
    private VisitEntity visit;

    @Comment("방문자 이름")
    private String name;

    @Comment("방문자 휴대폰 번호")
    private String mobilePhoneNumber;

    @Comment("방문자 회사")
    private String company;

    @Mapper
    public interface VisitorEntityMapper extends VisitDtoMapper {
        VisitorEntityMapper INSTANCE = Mappers.getMapper(VisitorEntityMapper.class);

        VisitorEntity toEntity(VisitorDto dto);

        VisitorDto toDto(VisitorEntity entity);
    }
}
