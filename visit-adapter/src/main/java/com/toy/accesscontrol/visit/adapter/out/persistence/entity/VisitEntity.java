package com.toy.accesscontrol.visit.adapter.out.persistence.entity;

import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.ZonedDateTime;

@Entity(name = "Visit")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class VisitEntity {
    @Id
    @Comment("고유 아이디")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("방문 시작 일시")
    private ZonedDateTime visitStartDateTime;

    @Comment("방문 종료 일시")
    private ZonedDateTime visitEndDateTime;

    @Comment("데이터 센터 아이디")
    private Long dataCenterId;

    @Comment("방문 사유")
    private String visitReason;

    @Comment("방문 상태")
    private VisitStatusVo status;

    @Comment("신청자 아이디")
    private String applicantUserId;

    public static VisitEntity from(VisitDto visit) {
        return new VisitEntity(
                visit.id() == null ? null : visit.id().value(),
                visit.visitPeriod().startDateTime(),
                visit.visitPeriod().endDateTime(),
                visit.dataCenterId().value(),
                visit.reason().value(),
                visit.status(),
                visit.applicantUserId().value()
        );
    }

    public VisitDto toDto() {
        return new VisitDto(
                VisitIdVo.from(id),
                VisitPeriodVo.of(visitStartDateTime, visitEndDateTime),
                VisitDataCenterIdVo.from(dataCenterId),
                VisitReasonVo.from(visitReason),
                status,
                ApplicantUserIdVo.from(applicantUserId)
        );
    }
}
