package com.M0o0o0o.springsecuritytemplate.user.service;

import com.M0o0o0o.springsecuritytemplate.user.Provider;
import com.M0o0o0o.springsecuritytemplate.user.Role;
import com.M0o0o0o.springsecuritytemplate.user.entity.User;
import com.M0o0o0o.springsecuritytemplate.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.M0o0o0o.springsecuritytemplate.user.dto.UserDTO.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User save(UserSingUpDTO dto) {
        if (checkDeplicateEmail(dto.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        return userRepository.save(
                User
                        .builder()
                        .email(dto.getEmail())
                        .password(passwordEncoder.encode(dto.getPassword()))
                        .nickname(dto.getNickname())
                        .provider(Provider.LOCAL)
                        .role(Role.ROLE_USER)
                        .build()
        );
    }

    private boolean checkDeplicateEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) return true;
        return false;
    }

}
