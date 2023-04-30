package com.toy.accesscontrol.datacenter.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.datacenter.domain.vo.DataCenterName;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record DataCenterNameVo(
        @NotEmpty
        @Length(min = 1, max = 5)
        @JsonValue
        String value
) {
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DataCenterNameVo from(String value) {
        return new DataCenterNameVo(value);
    }

    public static DataCenterNameVo fromDomain(DataCenterName domain) {
        if (domain == null) {
            return null;
        }

        return new DataCenterNameVo(domain.value());
    }

    public DataCenterName toDomain() {
        return DataCenterName.from(this.value);
    }
}
