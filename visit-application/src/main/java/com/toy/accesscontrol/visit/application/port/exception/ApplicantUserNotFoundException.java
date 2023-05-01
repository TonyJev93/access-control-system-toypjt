package com.toy.accesscontrol.visit.application.port.exception;

import com.toy.accesscontrol.visit.application.port.dto.vo.ApplicantUserIdVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApplicantUserNotFoundException extends NoSuchElementFoundException {
    public ApplicantUserNotFoundException(ApplicantUserIdVo value) {
        super("신청자", String.valueOf(value.value()));
    }
}
