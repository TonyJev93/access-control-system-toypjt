package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.MobilePhoneNumber;
import jakarta.validation.constraints.Pattern;

public record MobilePhoneNumberVo(
        @JsonValue
        @Pattern(regexp = REG_MOBILE_PHONE)
        String value
) {
    public static final String REG_MOBILE_PHONE = "01\\d{1}-\\d{4}-\\d{4}$";

    @JsonCreator
    public static MobilePhoneNumberVo from(String value) {
        return new MobilePhoneNumberVo(value);
    }

    public static MobilePhoneNumberVo fromDomain(MobilePhoneNumber domain) {
        return new MobilePhoneNumberVo(domain.value());
    }

    public MobilePhoneNumber toDomain() {
        return MobilePhoneNumber.from(this.value);
    }
}
