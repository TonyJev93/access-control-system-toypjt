package com.toy.accesscontrol.visit.domain;

import com.toy.accesscontrol.visit.domain.vo.EmailAddress;
import com.toy.accesscontrol.visit.domain.vo.MobilePhoneNumber;
import com.toy.accesscontrol.visit.domain.vo.RequesterName;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Requester {
    private RequesterName name;
    private MobilePhoneNumber mobilePhoneNumber;
    private EmailAddress emailAddress;

    public static Requester of(
            RequesterName name,
            MobilePhoneNumber mobilePhoneNumber,
            EmailAddress emailAddress
    ) {
        return new Requester(
                name,
                mobilePhoneNumber,
                emailAddress
        );
    }
}
