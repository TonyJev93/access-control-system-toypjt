package com.toy.accesscontrol.datacenter.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.datacenter.domain.vo.DataCenterName;
import jakarta.validation.constraints.NotEmpty;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

public record DataCenterNameVo(
        @NotEmpty
        @Length(min = LENGTH_MIN, max = LENGTH_MAX)
        @JsonValue
        String value
) {

    public static final int LENGTH_MIN = 1;
    public static final int LENGTH_MAX = 5;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DataCenterNameVo from(@NonNull String value) {
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
