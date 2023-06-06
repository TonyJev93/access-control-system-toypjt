package com.toy.accesscontrol.visit.adapter.out.persistence.entity;

import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.CompanyVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.MobilePhoneNumberVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitorIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitorNameVo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity(name = "Visitor")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class VisitorEntity {
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

    public static VisitorEntity fromDto(VisitorDto visitor) {
        return new VisitorEntity(
                visitor.id() == null ? null : visitor.id().value(),
                VisitEntity.fromDto(visitor.visit()),
                visitor.name().value(),
                visitor.mobilePhoneNumber().value(),
                visitor.company().value()
        );
    }

    public VisitorDto toDto() {
        return new VisitorDto(
                VisitorIdVo.from(id),
                visit.toDto(),
                VisitorNameVo.from(name),
                MobilePhoneNumberVo.from(mobilePhoneNumber),
                CompanyVo.from(company)
        );
    }

}
