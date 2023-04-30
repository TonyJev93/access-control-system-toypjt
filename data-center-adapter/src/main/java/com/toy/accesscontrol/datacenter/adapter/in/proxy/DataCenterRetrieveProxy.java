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

    public Optional<DataCenterDto> retrieve(RetrieveId id) {
        return dataCenterRetrieveUseCase.get(id.toApiVo());
    }

    public record RetrieveId(@JsonValue Long value) {
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public static RetrieveId from(Long value) {
            return new RetrieveId(value);
        }

        public DataCenterIdVo toApiVo() {
            return DataCenterIdVo.from(this.value);
        }
    }
}
