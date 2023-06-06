package com.toy.accesscontrol.visit.application.port.dto;

import com.toy.accesscontrol.visit.application.port.dto.vo.EmailAddressVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.MobilePhoneNumberVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.RequesterNameVo;
import com.toy.accesscontrol.visit.domain.Requester;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record RequesterDto(
        @Valid @NotNull RequesterNameVo name,
        @Valid @NotNull MobilePhoneNumberVo mobilePhoneNumber,
        @Valid @NotNull EmailAddressVo emailAddress
) {
    public static RequesterDto fromDomain(Requester requester) {
        return new RequesterDto(
                RequesterNameVo.fromDomain(requester.getName()),
                MobilePhoneNumberVo.fromDomain(requester.getMobilePhoneNumber()),
                EmailAddressVo.fromDomain(requester.getEmailAddress())
        );
    }

    public static RequesterDto of(RequesterNameVo name, MobilePhoneNumberVo mobilePhoneNumber, EmailAddressVo emailAddress) {
        return new RequesterDto(
                name,
                mobilePhoneNumber,
                emailAddress
        );
    }

    public Requester toDomain() {
        return Requester.of(
                name.toDomain(),
                mobilePhoneNumber.toDomain(),
                emailAddress.toDomain()
        );
    }
}
