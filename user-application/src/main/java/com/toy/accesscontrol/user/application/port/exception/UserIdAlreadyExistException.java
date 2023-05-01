package com.toy.accesscontrol.user.application.port.exception;

import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserIdAlreadyExistException extends RuntimeException {
    public UserIdAlreadyExistException(UserIdVo id) {
        super("이미 존재하는 사용자 아이디(%s)입니다.".formatted(id.value()));
    }
}
