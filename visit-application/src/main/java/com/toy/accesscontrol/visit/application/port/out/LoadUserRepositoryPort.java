package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.vo.ApplicantUserIdVo;

public interface LoadUserRepositoryPort {
    boolean isUserExist(ApplicantUserIdVo id);
}
