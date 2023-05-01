package com.toy.accesscontrol.visit.domain;

import com.toy.accesscontrol.visit.domain.vo.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Visitor {
    private VisitorId id;
    private VisitId visitId;
    private VisitorName name;
    private MobilePhoneNumber mobilePhoneNumber;
    private Company company;

    public static Visitor create(VisitId visitId, VisitorName name, MobilePhoneNumber mobilePhoneNumber, Company company) {
        return Visitor.builder()
                .visitId(visitId)
                .name(name)
                .mobilePhoneNumber(mobilePhoneNumber)
                .company(company)
                .build();
    }

    public static Visitor of(VisitorId id, VisitId visitId, VisitorName name, MobilePhoneNumber mobilePhoneNumber, Company company
    ) {
        return new Visitor(
                id,
                visitId,
                name,
                mobilePhoneNumber,
                company
        );
    }
}
