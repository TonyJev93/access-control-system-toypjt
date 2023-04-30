package com.toy.accesscontrol.visit.application.port.out;

import com.toy.accesscontrol.visit.application.port.dto.vo.ApplicantUserIdVo;

public interface LoadUserRepository {
    boolean isUserExist(ApplicantUserIdVo id);
}
