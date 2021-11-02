package com.project.capsback.domain;

import com.project.capsback.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {
    private String userId;
    private String password;
    private String phoneNumber;

    @Builder
    public UserRequest(String userId, String password, String phoneNumber){
        this.userId=userId;
        this.password=password;
        this.phoneNumber=phoneNumber;
    }

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .password(password)
                .phoneNumber(phoneNumber)
                .build();
    }

}
