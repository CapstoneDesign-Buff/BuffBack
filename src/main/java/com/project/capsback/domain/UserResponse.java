package com.project.capsback.domain;

import com.project.capsback.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponse {
    private String userId;
    private String password;
    private String phoneNumber;

    @Builder
    public UserResponse(final String userId,final String password,final String phoneNumber) {
        this.userId=userId;
        this.password=password;
        this.phoneNumber=phoneNumber;
    }

    public static UserResponse from(User user) {
        UserResponse userResponse = UserResponse.builder()
                .userId(user.getUserId())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();

        return userResponse;
    }
}
