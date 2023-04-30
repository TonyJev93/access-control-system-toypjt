package com.toy.accesscontrol.datacenter.domain;

import com.toy.accesscontrol.datacenter.domain.vo.DataCenterId;
import com.toy.accesscontrol.datacenter.domain.vo.DataCenterName;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class DataCenter {
    private DataCenterId id;
    private DataCenterName name;

    public static DataCenter create(DataCenterName name) {
        return DataCenter.builder()
                .name(name)
                .build();
    }

    public static DataCenter of(DataCenterId id, DataCenterName name) {
        return DataCenter.builder()
                .id(id)
                .name(name)
                .build();
    }
}
