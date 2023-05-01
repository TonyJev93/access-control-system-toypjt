package com.toy.accesscontrol.datacenter.adapter.in.proxy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterIdVo;
import com.toy.accesscontrol.datacenter.application.port.in.DataCenterRetrieveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DataCenterRetrieveProxy {

    private final DataCenterRetrieveUseCase dataCenterRetrieveUseCase;

    public Optional<RetrieveResponse> retrieve(RetrieveId id) {
        return dataCenterRetrieveUseCase.get(id.toApiVo())
                .map(RetrieveResponse::from);
    }

    public record RetrieveResponse(
            Long id,
            String name
    ) {
        public static RetrieveResponse from(DataCenterDto dto) {
            return new RetrieveResponse(
                    dto.id().value(),
                    dto.name().value()
            );
        }
    }

    public record RetrieveId(@JsonValue Long value) {
        @JsonCreator
        public static RetrieveId from(Long value) {
            return new RetrieveId(value);
        }

        public DataCenterIdVo toApiVo() {
            return DataCenterIdVo.from(this.value);
        }
    }
}
