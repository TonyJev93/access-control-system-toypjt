package com.toy.accesscontrol.datacenter.adapter.global.api.exception;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class DataCenterExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${exception.stack-trace.enable:false}")
    private boolean traceEnabled;

    @Value("${exception.stack-trace.param-name:trace}")
    private String traceParamName;

    private void setStackTraceIfSettingOn(
            Exception exception,
            WebRequest request,
            DataCenterErrorResponse<Object> errorResponse
    ) {
        if (traceEnabled) {
            var values = request.getParameterValues(traceParamName);
            var isTraceOn = Objects.nonNull(values) && values.length > 0 && values[0].contentEquals("true");

            if (isTraceOn) {
                errorResponse.setStackTrace(ExceptionUtils.getStackTrace(exception));
            }
        }
    }

    @Override
    @NonNull
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException exception,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request
    ) {
        log.error(exception.getMessage());

        var errorResponse = DataCenterErrorResponse.builder()
                .code(DataCenterError.UNPROCESSABLE_ENTITY.getErrorCode())
                .message("Validation error. Check 'result' field for details.")
                .build();

        for (var fieldError : exception.getBindingResult().getFieldErrors()) {
            errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        setStackTraceIfSettingOn(exception, request, errorResponse);

        return ResponseEntity.unprocessableEntity().body(errorResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRuntimeException(
            RuntimeException exception,
            WebRequest request
    ) {
        log.error(exception.getMessage());

        var errorConstant = DataCenterError.findMatchedError(exception);

        var errorResponse = DataCenterErrorResponse.builder()
                .code(errorConstant.getErrorCode())
                .message(exception.getMessage())
                .build();

        setStackTraceIfSettingOn(exception, request, errorResponse);

        return ResponseEntity.status(errorConstant.getHttpStatus()).body(errorResponse);
    }
}