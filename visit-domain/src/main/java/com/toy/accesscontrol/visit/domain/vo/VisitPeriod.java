package com.toy.accesscontrol.visit.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.ZonedDateTime;

public record VisitPeriod(
        @JsonValue ZonedDateTime startDateTime,
        @JsonValue ZonedDateTime endDateTime
) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
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
