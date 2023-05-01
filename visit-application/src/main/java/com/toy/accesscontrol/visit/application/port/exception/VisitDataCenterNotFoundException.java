package com.toy.accesscontrol.visit.application.port.exception;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitDataCenterIdVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VisitDataCenterNotFoundException extends NoSuchElementFoundException {
    public VisitDataCenterNotFoundException(VisitDataCenterIdVo value) {
        super("데이터 센터", String.valueOf(value.value()));
    }
}
