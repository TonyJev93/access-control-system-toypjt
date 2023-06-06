package com.toy.accesscontrol.visit.adapter.out.persistence.entity;

import com.toy.accesscontrol.visit.application.port.dto.RequesterDto;
import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.*;
import jakarta.persistence.*;
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
    @Column(name = "visit_id")
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
    @Enumerated(EnumType.STRING)
    private VisitStatusVo status;

    @Comment("신청자 아이디")
    private String applicantUserId;

    @Comment("신청자 이름")
    private String requesterName;

    @Comment("신청자 휴대 전화 번호")
    private String requesterMobilePhoneNumber;

    @Comment("신청자 이메일 주소")
    private String requesterEmailAddress;


    public static VisitEntity fromDto(VisitDto visit) {
        return new VisitEntity(
                visit.id() == null ? null : visit.id().value(),
                visit.visitPeriod().startDateTime(),
                visit.visitPeriod().endDateTime(),
                visit.dataCenterId().value(),
                visit.reason().value(),
                visit.status(),
                visit.applicantUserId().value(),
                visit.requester().name().value(),
                visit.requester().mobilePhoneNumber().value(),
                visit.requester().emailAddress().value()
        );
    }

    public VisitDto toDto() {
        return new VisitDto(
                VisitIdVo.from(id),
                VisitPeriodVo.of(visitStartDateTime, visitEndDateTime),
                VisitDataCenterIdVo.from(dataCenterId),
                VisitReasonVo.from(visitReason),
                status,
                ApplicantUserIdVo.from(applicantUserId),
                RequesterDto.of(
                        RequesterNameVo.from(requesterName),
                        MobilePhoneNumberVo.from(requesterMobilePhoneNumber),
                        EmailAddressVo.from(requesterEmailAddress)
                )
        );
    }
}
