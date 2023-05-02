package com.toy.accesscontrol.visit.adapter.out.proxy;

import com.toy.accesscontrol.datacenter.adapter.in.proxy.DataCenterRetrieveProxy;
import com.toy.accesscontrol.datacenter.adapter.in.proxy.DataCenterRetrieveProxy.RetrieveId;
import com.toy.accesscontrol.visit.application.port.dto.VisitDataCenterDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterNameVo;
import com.toy.accesscontrol.visit.application.port.out.LoadDataCenterRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataCenterClient implements LoadDataCenterRepositoryPort {

    private final DataCenterRetrieveProxy dataCenterRetrieveProxy;

    @Override
    public boolean isDataCenterExist(VisitDataCenterIdVo id) {
        return dataCenterRetrieveProxy.retrieve(RetrieveId.from(id.value()))
                .isPresent();
    }

    @Override
    public Optional<VisitDataCenterDto> findBy(VisitDataCenterIdVo id) {
        var dataCenterOptional = dataCenterRetrieveProxy.retrieve(RetrieveId.from(id.value()));

        return dataCenterOptional.map(
                response -> new VisitDataCenterDto(
                        VisitDataCenterIdVo.from(response.id()),
                        VisitDataCenterNameVo.from(response.name())
                )
        );
    }
}
