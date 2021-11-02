package com.project.capsback.service;

import com.project.capsback.domain.UserRepository;
import com.project.capsback.domain.UserRequest;
import com.project.capsback.domain.UserResponse;
import com.project.capsback.entity.User;
import com.project.capsback.exception.SignUpException;
import com.project.capsback.exception.UserDeleteException;
import com.project.capsback.exception.UserMismatchException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class UserService {
    public static final String NOT_FOUND_MESSAGE = "유저를 찾을수 없습니다.";
    public static final String PHONENUMBER_DUPLICATE_MESSAGE = "중복된 전화번호입니다.";

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public User findById(final String id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_FOUND_MESSAGE));
    }

    @Transactional(readOnly = true)
    public User findByPhoneNumber(final String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new EntityNotFoundException(NOT_FOUND_MESSAGE));
    }

    @Transactional(readOnly = true)
    public UserResponse findUserResponseById(final String id) {
        return UserResponse.from(findById(id));
    }

    public User save(final UserRequest userRequest) {
        try {
            checkPhoneNumberDuplicate(userRequest.getPhoneNumber());
            return userRepository.save(userRequest.toEntity());
        } catch (Exception e) {
            throw new SignUpException(e.getMessage());
        }
    }

    private void checkPhoneNumberDuplicate(String phoneNumber) {
        if (userRepository.findByPhoneNumber(phoneNumber).isPresent()) {
            throw new IllegalArgumentException(PHONENUMBER_DUPLICATE_MESSAGE);
        }
    }

    public void delete(final String userId, final String sessionUserId) {
        matchId(userId, sessionUserId);
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            throw new UserDeleteException();
        }
    }

    private void matchId(final String userId, final String sessionUserId) {
        if (userId == null || !userId.equals(sessionUserId)) {
            throw new UserMismatchException();
        }
    }
    public List<User> findByAll(){
        return userRepository.findAll();
    }

    public String update(String id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        user.update(userRequest);
        return user.getUserId();
    }
    public boolean existsById(final String id) {
        return userRepository.existsById(id);
    }
}
