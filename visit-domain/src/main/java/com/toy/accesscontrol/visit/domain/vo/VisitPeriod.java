package com.toy.accesscontrol.visit.domain.vo;

import java.time.ZonedDateTime;

public record VisitPeriod(
        ZonedDateTime startDateTime,
        ZonedDateTime endDateTime
) {
    public static VisitPeriod of(
            ZonedDateTime startDateTime,
            ZonedDateTime endDateTime
    ) {
        return new VisitPeriod(
                startDateTime,
                endDateTime
        );
    }
}
