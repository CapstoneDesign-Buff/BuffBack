package com.project.capsback.service;

import com.project.capsback.exception.UserDeleteException;
import com.project.capsback.exception.UserMismatchException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDeleteService {
    private final UserService userService;

    public UserDeleteService(final UserService userService) {
        this.userService = userService;
    }

    public void delete(final String userId, final Long sessionUserId) {
        matchId(userId, sessionUserId);
        try {
            userService.delete(userId, sessionUserId);
        } catch (Exception e) {
            throw new UserDeleteException();
        }
    }

    private void matchId(final String userId, final Long sessionUserId) {
        if (userId == null || !userId.equals(sessionUserId)) {
            throw new UserMismatchException();
        }
    }


}
