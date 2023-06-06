package com.toy.accesscontrol.visit.application.port.dto;

import com.toy.accesscontrol.visit.application.port.dto.vo.CompanyVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.MobilePhoneNumberVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitorIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitorNameVo;
import com.toy.accesscontrol.visit.domain.Visitor;

public record VisitorDto(
        VisitorIdVo id,
        VisitDto visit,
        VisitorNameVo name,
        MobilePhoneNumberVo mobilePhoneNumber,
        CompanyVo company
) {
    public static VisitorDto fromDomain(Visitor visitor) {
        return new VisitorDto(
                visitor.getId() == null ? null : VisitorIdVo.fromDomain(visitor.getId()),
                VisitDto.fromDomain(visitor.getVisit()),
                VisitorNameVo.fromDomain(visitor.getName()),
                MobilePhoneNumberVo.fromDomain(visitor.getMobilePhoneNumber()),
                CompanyVo.fromDomain(visitor.getCompany())
        );
    }

    public Visitor toDomain() {
        return Visitor.of(
                id.toDomain(),
                visit.toDomain(),
                name.toDomain(),
                mobilePhoneNumber.toDomain(),
                company.toDomain()
        );
    }
}
