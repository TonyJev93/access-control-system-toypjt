package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.domain.vo.VisitorId;
import lombok.NonNull;

import java.util.Optional;

public record VisitorIdVo(@JsonValue Long value) {

    @JsonCreator
    public static VisitorIdVo from(@NonNull Long value) {
        return new VisitorIdVo(value);
    }

    public static VisitorIdVo fromDomain(@NonNull VisitorId domain) {
        return new VisitorIdVo(domain.value());
    }

    public VisitorId toDomain() {
        return VisitorId.from(this.value);
    }

    public interface Mapper {
        default Long visitorIdVo(VisitorIdVo id) {
            return Optional.ofNullable(id).map(VisitorIdVo::value).orElse(null);
        }

        default VisitorIdVo visitorIdVo(Long id) {
            return Optional.ofNullable(id).map(VisitorIdVo::from).orElse(null);
        }
    }
}
