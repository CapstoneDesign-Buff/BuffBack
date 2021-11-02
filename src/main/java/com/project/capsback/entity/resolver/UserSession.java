package com.project.capsback.entity.resolver;

import com.project.capsback.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionBindingListener;

@Getter
@ToString
@NoArgsConstructor
public class UserSession implements HttpSessionBindingListener {

    public static final String USER_SESSION_KEY = "loginUser";

    private String userId;
    private String phoneNumber;

    @Builder
    private UserSession(String userId, String phoneNumber) {
        this.userId=userId;
        this.phoneNumber=phoneNumber;
    }

    public static UserSession from(User user) {
        return UserSession.builder()
                .userId(user.getUserId())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}