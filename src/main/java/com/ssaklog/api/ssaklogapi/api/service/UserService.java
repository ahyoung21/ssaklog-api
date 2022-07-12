package com.ssaklog.api.ssaklogapi.api.service;

import com.ssaklog.api.ssaklogapi.api.dto.AddUserRequest;
import com.ssaklog.api.ssaklogapi.api.dto.AddUserTempRequest;
import com.ssaklog.api.ssaklogapi.api.dto.CheckUserOverlapIdRequest;
import com.ssaklog.api.ssaklogapi.api.entity.User;
import com.ssaklog.api.ssaklogapi.api.enums.ErrorCode;
import com.ssaklog.api.ssaklogapi.api.exception.CustomException;
import com.ssaklog.api.ssaklogapi.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service(value = "userService")
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User tempAdd(AddUserTempRequest request) {
        return userRepository.save(User
                .builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .userName("test")
                .joinDate(LocalDateTime.now())
                .dormantYn("N")
                .withdrawYn("N")
                .build());
    }

    public User add(AddUserRequest request) {
        validateSignUp(request);
        return null;
    }

    private void validateSignUp(AddUserRequest request) {
        if (request.getUserId() == null || request.getUserId().equals("")) { // TODO : 체크 방법
            throw new CustomException(ErrorCode.EMPTY_USER_ID);
        }
    }

    /**
     * 회원 아이디 중복 체크
     *
     * @param request
     * @return
     */
    public boolean checkOverlapId(CheckUserOverlapIdRequest request) {
        return userRepository.countAllByUserId(request.getUserId()) <= 0;
    }

}
