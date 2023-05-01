package com.toy.accesscontrol.user.adapter.in.proxy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.user.adapter.in.api.dto.UserResponse;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;
import com.toy.accesscontrol.user.application.port.in.UserRetrieveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRetrieveProxy {

    private final UserRetrieveUseCase userRetrieveUseCase;

    public Optional<UserResponse> retrieve(RetrieveId id) {
        return userRetrieveUseCase.get(id.toApiVo()).map(UserResponse::from);
    }

    public record RetrieveId(@JsonValue String value) {
        @JsonCreator
        public static RetrieveId from(String value) {
            return new RetrieveId(value);
        }

        public UserIdVo toApiVo() {
            return UserIdVo.from(this.value);
        }
    }
}
