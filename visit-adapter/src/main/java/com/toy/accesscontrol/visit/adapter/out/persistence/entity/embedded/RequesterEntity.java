package com.toy.accesscontrol.visit.adapter.out.persistence.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.Comment;

@Embeddable
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class RequesterEntity {
    @Comment("신청자 이름")
    private String name;

    @Comment("신청자 휴대 전화 번호")
    private String mobilePhoneNumber;

    @Comment("신청자 이메일 주소")
    private String emailAddress;
}
