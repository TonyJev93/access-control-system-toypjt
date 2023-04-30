package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.VisitPeriod;

import java.time.ZonedDateTime;

public record VisitPeriodVo(
        @JsonValue ZonedDateTime startDateTime,
        @JsonValue ZonedDateTime endDateTime
) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static VisitPeriodVo of(
            ZonedDateTime startDateTime,
            ZonedDateTime endDateTime
    ) {
        return new VisitPeriodVo(
                startDateTime,
                endDateTime
        );
    }

    public static VisitPeriodVo fromDomain(VisitPeriod domain) {
        return new VisitPeriodVo(
                domain.startDateTime(),
                domain.endDateTime()
        );
    }

    public VisitPeriod toDomain() {
        return VisitPeriod.of(this.startDateTime, this.endDateTime);
    }
}
