package com.toy.accesscontrol.visit.application.port.dto;

import com.toy.accesscontrol.visit.application.port.dto.vo.*;
import com.toy.accesscontrol.visit.domain.Visitor;

public record VisitorDto(
        VisitorIdVo id,
        VisitIdVo visitId,
        VisitorNameVo name,
        MobilePhoneNumberVo mobilePhoneNumber,
        CompanyVo company
) {
    public static VisitorDto fromDomain(Visitor visitor) {
        return new VisitorDto(
                visitor.getId() == null ? null : VisitorIdVo.fromDomain(visitor.getId()),
                VisitIdVo.fromDomain(visitor.getVisitId()),
                VisitorNameVo.fromDomain(visitor.getName()),
                MobilePhoneNumberVo.fromDomain(visitor.getMobilePhoneNumber()),
                CompanyVo.fromDomain(visitor.getCompany())
        );
    }

    public Visitor toDomain() {
        return Visitor.of(
                id.toDomain(),
                visitId.toDomain(),
                name.toDomain(),
                mobilePhoneNumber.toDomain(),
                company.toDomain()
        );
    }
}
