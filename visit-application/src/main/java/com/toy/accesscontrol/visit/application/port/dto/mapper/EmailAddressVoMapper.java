package com.toy.accesscontrol.visit.application.port.dto.mapper;


import com.toy.accesscontrol.visit.application.port.dto.vo.EmailAddressVo;

import java.util.Optional;

public interface EmailAddressVoMapper {
    default String emailAddressVo(EmailAddressVo value) {
        return Optional.ofNullable(value).map(EmailAddressVo::value).orElse(null);
    }

    default EmailAddressVo emailAddressVo(String value) {
        return Optional.ofNullable(value).map(EmailAddressVo::from).orElse(null);
    }
}
