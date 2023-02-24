package com.M0o0o0o.springsecuritytemplate.user;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    ROLE_USER("ROLE_USER"),
    ;

    private String role;
}
