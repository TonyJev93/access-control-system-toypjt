package com.toy.accesscontrol.datacenter.adapter.out.persistence.entity;

import com.toy.accesscontrol.datacenter.domain.DataCenter;
import com.toy.accesscontrol.datacenter.domain.vo.DataCenterName;
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
    @Comment("데이터 센터 고유 아이디")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("데이터 센터 이름")
    private String name;

    public static DataCenterEntity from(DataCenter dataCenter) {
        return new DataCenterEntity(
                dataCenter.getId(),
                dataCenter.getName().value()
        );
    }

    public DataCenter toDomain() {
        return DataCenter.of(
                id,
                DataCenterName.from(name)
        );
    }
}
