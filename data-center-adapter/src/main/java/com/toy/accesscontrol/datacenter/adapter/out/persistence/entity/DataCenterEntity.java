package com.toy.accesscontrol.datacenter.adapter.out.persistence.entity;

import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterIdVo;
import com.toy.accesscontrol.datacenter.application.port.dto.vo.DataCenterNameVo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity(name = "DataCenter")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DataCenterEntity {
    @Id
    @Comment("고유 아이디")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("데이터 센터 이름")
    private String name;

    public static DataCenterEntity from(DataCenterDto dataCenter) {
        return new DataCenterEntity(
                dataCenter.id() == null ? null : dataCenter.id().value(),
                dataCenter.name().value()
        );
    }

    public DataCenterDto toDto() {
        return DataCenterDto.of(
                DataCenterIdVo.from(id),
                DataCenterNameVo.from(name)
        );
    }
}
