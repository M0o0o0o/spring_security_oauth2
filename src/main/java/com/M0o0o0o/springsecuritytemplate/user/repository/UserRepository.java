package com.M0o0o0o.springsecuritytemplate.user.repository;

import com.M0o0o0o.springsecuritytemplate.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);
}
