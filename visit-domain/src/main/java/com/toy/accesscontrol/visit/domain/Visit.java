package com.toy.accesscontrol.visit.domain;

import com.toy.accesscontrol.visit.domain.vo.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Visit {
    private VisitId id;
    private VisitPeriod visitPeriod;
    private VisitDataCenterId dataCenterId;
    private VisitReason reason;
    private VisitStatus status;
    private ApplicantUserId applicantUserId;

    public static Visit applied(
            VisitPeriod visitPeriod,
            VisitDataCenterId dataCenterId,
            VisitReason reason,
            ApplicantUserId applicantUserId
    ) {
        return Visit.builder()
                .visitPeriod(visitPeriod)
                .dataCenterId(dataCenterId)
                .reason(reason)
                .applicantUserId(applicantUserId)
                .status(VisitStatus.APPLIED)
                .build();
    }

    public static Visit of(VisitId id, VisitPeriod visitPeriod, VisitDataCenterId dataCenterId, VisitReason reason, VisitStatus status, ApplicantUserId applicantUserId) {
        return new Visit(
                id,
                visitPeriod,
                dataCenterId,
                reason,
                status,
                applicantUserId
        );
    }
}
