package com.project.capsback.controller;

import com.project.capsback.domain.LoginRequest;
import com.project.capsback.domain.UserResponse;
import com.project.capsback.entity.resolver.LoginUser;
import com.project.capsback.entity.resolver.UserSession;
import com.project.capsback.service.LoginService;
import com.project.capsback.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.project.capsback.entity.resolver.UserSession.USER_SESSION_KEY;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;
    private final UserService userService;

    public LoginController(final LoginService loginService, final UserService userService) {
        this.loginService = loginService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest, HttpSession httpSession) {
        UserSession userSession = loginService.login(loginRequest);
        httpSession.setAttribute(USER_SESSION_KEY, userSession);
        return ResponseEntity.ok(userService.findUserResponseById(userSession.getUserId()));
    }

    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@LoginUser UserSession memberSession, HttpSession httpSession) {
        loginService.logout(memberSession.getUserId());
        httpSession.removeAttribute(USER_SESSION_KEY);
        return ResponseEntity.ok().build();
    }
}

