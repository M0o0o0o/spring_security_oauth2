package com.M0o0o0o.springsecuritytemplate.user.entity;

import com.M0o0o0o.springsecuritytemplate.user.Provider;
import com.M0o0o0o.springsecuritytemplate.user.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String password;
    private String email;
    private String nickname;
    private String socialId;

    @Enumerated(EnumType.STRING)
    private Provider provider;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String password, String email, String nickname, String socialId, Provider provider, Role role) {
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.socialId = socialId;
        this.provider = provider;
        this.role = role;
    }
}
