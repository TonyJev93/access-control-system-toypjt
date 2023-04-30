package com.toy.accesscontrol.user.adapter.out.persistence.entity;

import com.toy.accesscontrol.user.application.port.dto.UserDto;
import com.toy.accesscontrol.user.application.port.dto.vo.PasswordVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserIdVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserNameVo;
import com.toy.accesscontrol.user.application.port.dto.vo.UserRoleVo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity(name = "Member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserEntity {
    @Id
    @Comment("사용자 아이디")
    private String userId;

    @Comment("비밀번호")
    private String password;

    @Comment("사용자 이름")
    private String name;

    @Comment("사용자 권한")
    @Enumerated(EnumType.STRING)
    private UserRoleVo userRole;

    public static UserEntity from(UserDto dto) {
        return new UserEntity(
                dto.userId().value(),
                dto.password().value(),
                dto.name().value(),
                dto.role()
        );
    }

    public UserDto toDto() {
        return UserDto.of(
                UserIdVo.from(userId),
                PasswordVo.from(password),
                UserNameVo.from(name),
                userRole
        );
    }
}
