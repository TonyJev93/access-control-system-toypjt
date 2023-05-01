package com.toy.accesscontrol.datacenter.adapter.global.api.exception;

import com.toy.accesscontrol.datacenter.application.port.exception.NoSuchElementFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static com.toy.accesscontrol.datacenter.adapter.global.api.DataCenterApiResponse.PREFIX_OF_ERROR_CODE;

@Getter
@RequiredArgsConstructor
public enum DataCenterError {
    // Common Error Code
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "", new Class[]{ConstraintViolationException.class}),
    NOT_FOUND(HttpStatus.NOT_FOUND, "", new Class[]{NoSuchElementFoundException.class}),
    UNPROCESSABLE_ENTITY(HttpStatus.UNPROCESSABLE_ENTITY, "", new Class[]{MethodArgumentNotValidException.class}),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "", new Class[]{RuntimeException.class}),
    ;

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final Class<? extends Exception>[] matchedExceptions;

    public static DataCenterError findMatchedError(Exception exception) {
        for (var error : DataCenterError.values()) {
            for (var clazz : error.getMatchedExceptions()) {
                if (clazz.isInstance(exception)) {
                    return error;
                }
            }
        }

        return INTERNAL_SERVER_ERROR;
    }

    public String getErrorCode() {
        if (Strings.isEmpty(errorCode)) {
            return PREFIX_OF_ERROR_CODE + httpStatus.value();
        }

        return PREFIX_OF_ERROR_CODE + errorCode;
    }
}
