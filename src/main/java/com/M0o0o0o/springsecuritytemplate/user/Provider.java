package com.M0o0o0o.springsecuritytemplate.user;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Provider {
    LOCAL("local"), KAKAO("kakao"), GOOGLE("google"), NAVER("naver"),
    ;
    private String name;
}
