package com.project.capsback.service;

import com.project.capsback.domain.UserRequest;
import com.project.capsback.domain.UserResponse;
import com.project.capsback.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserCreateService {
    private final UserService userService;

    public UserCreateService(final UserService userService) {
        this.userService = userService;
    }

    public UserResponse create(UserRequest userRequest) {
        User user = userService.save(userRequest);
        return UserResponse.from(user);
    }
}
