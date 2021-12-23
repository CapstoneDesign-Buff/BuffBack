package com.project.capsback.service;

import com.project.capsback.domain.LoginRequest;
import com.project.capsback.domain.UserRequest;
import com.project.capsback.entity.User;
import com.project.capsback.entity.resolver.UserSession;
import com.project.capsback.exception.LoginFailException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.CorsFilter;
import java.time.LocalDateTime;


@Service
@Transactional
public class LoginService {

    private final UserService userService;

    public LoginService(final UserService userService) {
        this.userService = userService;
    }

    public UserSession login(final LoginRequest loginRequest) {
        try {
            User user = userService.findById(loginRequest.getUserId());
            user.matchPassword(loginRequest.getPassword());
            checkLoginAndUpdateLogoutAt(user);
            user.setLoginTime(LocalDateTime.now());
            user.setLoginStatus(true);
            return UserSession.from(user);
        } catch (Exception e) {
            throw new LoginFailException(e.getMessage());
        }
    }

    public void logout(final String userId) {
        User user = userService.findById(userId);
        checkLoginAndUpdateLogoutAt(user);
    }

    private void checkLoginAndUpdateLogoutAt(User user) {
        if (user.isLoginStatus()) {
            user.setLogoutTime(LocalDateTime.now());
        }
    }
}
