package com.ssaklog.api.ssaklogapi.api.service;

import com.ssaklog.api.ssaklogapi.api.dto.SignInRequest;
import com.ssaklog.api.ssaklogapi.api.entity.User;
import com.ssaklog.api.ssaklogapi.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignInService {

    private final UserRepository userRepository;

    public void signIn(SignInRequest request) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findTopByUserIdOrderByWithdrawYnDescUserSeqDesc(request.getUserId()));


    }
}
