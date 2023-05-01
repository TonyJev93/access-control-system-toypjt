package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.VisitPeriod;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;

public record VisitPeriodVo(
        @JsonValue
        @NotNull
        @Future
        ZonedDateTime startDateTime,

        @JsonValue
        @NotNull
        @Future
        ZonedDateTime endDateTime
) {

    @JsonCreator
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

    @AssertTrue
    public boolean isStartDateTimeBeforeEndDateTime() {
        if (startDateTime == null || endDateTime == null) {
            return true;
        }
        return startDateTime.isBefore(endDateTime);
    }

    public VisitPeriod toDomain() {
        return VisitPeriod.of(this.startDateTime, this.endDateTime);
    }
}
