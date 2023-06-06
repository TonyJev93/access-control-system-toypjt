package com.toy.accesscontrol.visit.adapter.out.persistence.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.ZonedDateTime;

@Embeddable
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class VisitPeriodEntity {
    @Comment("방문 시작 일시")
    private ZonedDateTime startDateTime;

    @Comment("방문 종료 일시")
    private ZonedDateTime endDateTime;
}
