package com.M0o0o0o.springsecuritytemplate.user.controller;


import com.M0o0o0o.springsecuritytemplate.user.dto.UserDTO;
import com.M0o0o0o.springsecuritytemplate.user.entity.User;
import com.M0o0o0o.springsecuritytemplate.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.M0o0o0o.springsecuritytemplate.user.dto.UserDTO.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentEx(IllegalArgumentException e) {
        return e.getMessage();
    }

    @PostMapping("/user/signup")
    public UserRes signUp(@RequestBody @Validated UserSingUpDTO signUpDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("입력 값을 확인해주세요.");
        }

        User savedUser = userService.save(signUpDto);

        return UserRes
                .builder()
                .email(savedUser.getEmail())
                .nickname(savedUser.getNickname())
                .build();
    }
}
