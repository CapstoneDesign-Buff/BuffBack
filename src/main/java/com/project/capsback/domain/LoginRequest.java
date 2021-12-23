package com.project.capsback.domain;

import com.project.capsback.entity.User;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class LoginRequest {
    @NotNull
    private String userId;
    @NotNull
    private String password;

    @Builder
    public LoginRequest(String userId, String password){
        this.userId=userId;
        this.password=password;

    }

}

