package com.toy.accesscontrol.visit.application.port.exception;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VisitNotFoundException extends NoSuchElementFoundException {
    public VisitNotFoundException(VisitIdVo value) {
        super("방문 정보", String.valueOf(value.value()));
    }
}
