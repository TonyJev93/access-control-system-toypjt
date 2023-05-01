package com.toy.accesscontrol.visit.adapter.out.persistence.entity;

import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Comment("방문 아이디")
    private Long visitId;

    @Comment("방문자 이름")
    private String name;

    @Comment("방문자 휴대폰 번호")
    private String mobilePhoneNumber;

    @Comment("방문자 회사")
    private String company;

    public static VisitorEntity from(VisitorDto visitor) {
        return new VisitorEntity(
                visitor.id() == null ? null : visitor.id().value(),
                visitor.visitId().value(),
                visitor.name().value(),
                visitor.mobilePhoneNumber().value(),
                visitor.company().value()
        );
    }

    public VisitorDto toDto() {
        return new VisitorDto(
                VisitorIdVo.from(id),
                VisitIdVo.from(visitId),
                VisitorNameVo.from(name),
                MobilePhoneNumberVo.from(mobilePhoneNumber),
                CompanyVo.from(company)
        );
    }

}
