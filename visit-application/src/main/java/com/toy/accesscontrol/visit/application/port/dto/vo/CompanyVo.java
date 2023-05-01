package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.Company;

public record CompanyVo(@JsonValue String value) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CompanyVo from(String value) {
        return new CompanyVo(value);
    }

    public static CompanyVo fromDomain(Company domain) {
        return new CompanyVo(domain.value());
    }

    public Company toDomain() {
        return Company.from(this.value);
    }
}
