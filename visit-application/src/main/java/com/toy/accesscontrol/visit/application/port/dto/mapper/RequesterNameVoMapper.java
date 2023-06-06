package com.toy.accesscontrol.visit.application.port.dto.mapper;


import com.toy.accesscontrol.visit.application.port.dto.vo.RequesterNameVo;

import java.util.Optional;

public interface RequesterNameVoMapper {
    default String requesterNameVo(RequesterNameVo value) {
        return Optional.ofNullable(value).map(RequesterNameVo::value).orElse(null);
    }

    default RequesterNameVo requesterNameVo(String value) {
        return Optional.ofNullable(value).map(RequesterNameVo::from).orElse(null);
    }
}
