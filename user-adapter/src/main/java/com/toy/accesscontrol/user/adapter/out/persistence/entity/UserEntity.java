package com.toy.accesscontrol.user.adapter.out.persistence.entity;

import com.toy.accesscontrol.user.domain.User;
import com.toy.accesscontrol.user.domain.vo.Password;
import com.toy.accesscontrol.user.domain.vo.UserId;
import com.toy.accesscontrol.user.domain.vo.UserName;
import com.toy.accesscontrol.user.domain.vo.UserRole;
import jakarta.persistence.*;
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
    @Comment("사용자 고유 아이디")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("사용자 아이디")
    @Column(unique = true)
    private String userId;

    @Comment("비밀번호")
    private String password;

    @Comment("사용자 이름")
    private String name;

    @Comment("사용자 권한")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public static UserEntity from(User user) {
        return new UserEntity(
                user.getId(),
                user.getUserId().value(),
                user.getPassword().value(),
                user.getName().value(),
                user.getRole()
        );
    }

    public User toDomain() {
        return User.of(
                id,
                UserId.from(userId),
                Password.from(password),
                UserName.from(name),
                userRole
        );
    }
}
