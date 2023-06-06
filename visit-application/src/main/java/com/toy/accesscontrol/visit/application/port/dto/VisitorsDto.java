package com.toy.accesscontrol.visit.application.port.dto;

import com.toy.accesscontrol.visit.domain.Visitors;

import java.util.List;

public record VisitorsDto(
        List<VisitorDto> values
) {
    public static VisitorsDto fromDomain(Visitors visitors) {
        return new VisitorsDto(
                visitors.getValues()
                        .stream()
                        .map(VisitorDto::fromDomain)
                        .toList()
        );
    }

    public static VisitorsDto from(List<VisitorDto> visitors) {
        return new VisitorsDto(
                visitors
        );
    }

    public Visitors toDomain() {
        var visitorDomains =
                this.values.stream()
                        .map(VisitorDto::toDomain)
                        .toList();

        return Visitors.from(
                visitorDomains
        );
    }
}
