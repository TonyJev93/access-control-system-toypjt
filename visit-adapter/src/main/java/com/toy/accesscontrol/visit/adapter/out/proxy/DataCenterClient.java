package com.toy.accesscontrol.visit.adapter.out.proxy;

import com.toy.accesscontrol.datacenter.adapter.in.proxy.DataCenterRetrieveProxy;
import com.toy.accesscontrol.datacenter.adapter.in.proxy.DataCenterRetrieveProxy.RetrieveId;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;
import com.toy.accesscontrol.visit.application.port.out.LoadDataCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataCenterClient implements LoadDataCenterRepository {

    private final DataCenterRetrieveProxy dataCenterRetrieveProxy;

    @Override
    public boolean isDataCenterExist(VisitDataCenterIdVo id) {
        return dataCenterRetrieveProxy.retrieve(RetrieveId.from(id.value()))
                .isPresent();
    }
}
