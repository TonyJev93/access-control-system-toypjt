package com.toy.accesscontrol.visit.domain;

import com.toy.accesscontrol.visit.domain.vo.Company;
import com.toy.accesscontrol.visit.domain.vo.MobilePhoneNumber;
import com.toy.accesscontrol.visit.domain.vo.VisitorId;
import com.toy.accesscontrol.visit.domain.vo.VisitorName;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Visitor {
    private VisitorId id;
    private Visit visit;
    private VisitorName name;
    private MobilePhoneNumber mobilePhoneNumber;
    private Company company;

    public static Visitor create(Visit visit, VisitorName name, MobilePhoneNumber mobilePhoneNumber, Company company) {
        return Visitor.builder()
                .visit(visit)
                .name(name)
                .mobilePhoneNumber(mobilePhoneNumber)
                .company(company)
                .build();
    }

    public static Visitor of(VisitorId id, Visit visit, VisitorName name, MobilePhoneNumber mobilePhoneNumber, Company company
    ) {
        return new Visitor(
                id,
                visit,
                name,
                mobilePhoneNumber,
                company
        );
    }
}
