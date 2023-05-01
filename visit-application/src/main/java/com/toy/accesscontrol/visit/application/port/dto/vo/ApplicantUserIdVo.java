package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.ApplicantUserId;
import lombok.NonNull;

public record ApplicantUserIdVo(@JsonValue String value) {

    @JsonCreator
    public static ApplicantUserIdVo from(@NonNull String value) {
        return new ApplicantUserIdVo(value);
    }

    public static ApplicantUserIdVo fromDomain(@NonNull ApplicantUserId domain) {
        return new ApplicantUserIdVo(domain.value());
    }

    public ApplicantUserId toDomain() {
        return ApplicantUserId.from(this.value);
    }
}
