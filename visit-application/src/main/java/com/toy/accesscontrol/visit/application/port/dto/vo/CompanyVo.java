package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.Company;

import java.util.Optional;

public record CompanyVo(@JsonValue String value) {

    @JsonCreator
    public static CompanyVo from(String value) {
        return new CompanyVo(value);
    }

    public static CompanyVo fromDomain(Company domain) {
        return new CompanyVo(domain.value());
    }

    public Company toDomain() {
        return Company.from(this.value);
    }

    public interface Mapper {
        default String companyVo(CompanyVo value) {
            return Optional.ofNullable(value).map(CompanyVo::value).orElse(null);
        }

        default CompanyVo companyVo(String value) {
            return Optional.ofNullable(value).map(CompanyVo::from).orElse(null);
        }
    }
}
