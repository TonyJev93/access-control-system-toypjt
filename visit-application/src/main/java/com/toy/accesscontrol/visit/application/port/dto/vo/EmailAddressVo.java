package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.EmailAddress;
import jakarta.validation.constraints.Email;

import java.util.Optional;

public record EmailAddressVo(
        @JsonValue
        @Email
        String value
) {
    @JsonCreator
    public static EmailAddressVo from(String value) {
        return new EmailAddressVo(value);
    }

    public static EmailAddressVo fromDomain(EmailAddress domain) {
        return new EmailAddressVo(domain.value());
    }

    public EmailAddress toDomain() {
        return EmailAddress.from(this.value);
    }

    public interface Mapper {
        default String emailAddressVo(EmailAddressVo value) {
            return Optional.ofNullable(value).map(EmailAddressVo::value).orElse(null);
        }

        default EmailAddressVo emailAddressVo(String value) {
            return Optional.ofNullable(value).map(EmailAddressVo::from).orElse(null);
        }
    }
}
