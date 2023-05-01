package com.toy.accesscontrol.user.adapter.global.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.toy.accesscontrol.user.adapter.global.api.UserApiResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@SuperBuilder
public class UserErrorResponse<T> extends UserApiResponse<T> {
    @Builder.Default
    private boolean successful = false;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stackTrace;

    @SuppressWarnings("unchecked")
    public void addValidationError(String field, String message) {
        if (Objects.isNull(this.result)) {
            this.result = (T) new ArrayList<>();
        }

        ((List<ValidationError>) this.result).add(new ValidationError(field, message));
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @RequiredArgsConstructor
    @Getter
    protected static class ValidationError {
        private final String field;
        private final String message;
    }
}
