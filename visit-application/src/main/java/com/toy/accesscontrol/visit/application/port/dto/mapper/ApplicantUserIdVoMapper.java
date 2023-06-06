package com.toy.accesscontrol.visit.application.port.dto.mapper;


import com.toy.accesscontrol.visit.application.port.dto.vo.ApplicantUserIdVo;

import java.util.Optional;

public interface ApplicantUserIdVoMapper {
    default String applicantUserIdVo(ApplicantUserIdVo id) {
        return Optional.ofNullable(id).map(ApplicantUserIdVo::value).orElse(null);
    }

    default ApplicantUserIdVo applicantUserIdVo(String id) {
        return Optional.ofNullable(id).map(ApplicantUserIdVo::from).orElse(null);
    }
}
