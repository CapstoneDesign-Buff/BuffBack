package com.project.capsback.controller;

import com.project.capsback.domain.UserRequest;
import com.project.capsback.domain.UserResponse;
import com.project.capsback.entity.User;
import com.project.capsback.entity.resolver.LoginUser;
import com.project.capsback.entity.resolver.UserSession;
import com.project.capsback.service.UserCreateService;
import com.project.capsback.service.UserDeleteService;
import com.project.capsback.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserApiController {
    private final UserService userService;
    private final UserCreateService userCreateService;
    private final UserDeleteService userDeleteService;

    public UserApiController(final UserService userService,
                             final UserCreateService userCreateService,
                             final UserDeleteService userDeleteService) {
        this.userService = userService;
        this.userCreateService = userCreateService;
        this.userDeleteService = userDeleteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> show(@PathVariable String id) { //특정 사용자의 정보 조회
        return ResponseEntity.ok(userService.findUserResponseById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) { //사용자 신규 생성
        UserResponse userResponse = userCreateService.create(userRequest);
        return ResponseEntity.ok().body(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<User>> showAll(){ //모든 사용자의 정보 조회
        return ResponseEntity.ok(userService.findByAll());
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable String id,@RequestBody UserRequest userRequest){//특정 사용자 정보 조회
        userService.update(id,userRequest);
        return id;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable String id, @LoginUser UserSession userSession, HttpSession httpSession){ //특정 사용자 삭제
        userService.delete(id,userSession.getUserId());
        httpSession.removeAttribute(UserSession.USER_SESSION_KEY);
        return ResponseEntity.noContent().build();
    }
}
