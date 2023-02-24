package com.M0o0o0o.springsecuritytemplate.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class UserDTO {

    @Data
    @NoArgsConstructor
    public static class UserSingUpDTO {
        @NotNull
        private String email;
        @NotNull
        private String password;
        @NotNull
        private String nickname;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserRes {
        private String email;
        private String nickname;
    }


}
