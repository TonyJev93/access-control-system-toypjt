package com.toy.accesscontrol.visit.application.port.dto.mapper;


import com.toy.accesscontrol.visit.application.port.dto.vo.MobilePhoneNumberVo;

import java.util.Optional;

public interface MobilePhoneNumberVoMapper {
    default String mobilePhoneNumberVo(MobilePhoneNumberVo value) {
        return Optional.ofNullable(value).map(MobilePhoneNumberVo::value).orElse(null);
    }

    default MobilePhoneNumberVo mobilePhoneNumberVo(String value) {
        return Optional.ofNullable(value).map(MobilePhoneNumberVo::from).orElse(null);
    }
}
