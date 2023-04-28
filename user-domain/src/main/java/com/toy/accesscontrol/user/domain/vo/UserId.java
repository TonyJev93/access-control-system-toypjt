package com.toy.accesscontrol.user.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record UserId(
        @JsonValue // [Description] 직렬화 할 때 필드 이름을 제외한 값(value)만 반환
        String value
) {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING) // [Description] 역직렬화 시 static or 생성자 필요(httpRequest -> DTO)
    public static UserId from(String value) {
        return new UserId(value);
    }

}
