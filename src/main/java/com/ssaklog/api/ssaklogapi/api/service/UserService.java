package com.ssaklog.api.ssaklogapi.api.service;

import com.ssaklog.api.ssaklogapi.api.dto.UserTempAddRequest;
import com.ssaklog.api.ssaklogapi.api.entity.User;
import com.ssaklog.api.ssaklogapi.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service(value = "userService")
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User tempAdd(UserTempAddRequest request) {
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

}
