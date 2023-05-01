package com.toy.accesscontrol.datacenter.application.port.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException extends RuntimeException {
    public NoSuchElementFoundException(String elementType, String value) {
        super("존재하지 않는 %s(%s)입니다.".formatted(elementType, value));
    }
}
