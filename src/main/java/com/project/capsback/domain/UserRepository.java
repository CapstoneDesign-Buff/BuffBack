package com.project.capsback.domain;

import com.project.capsback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
