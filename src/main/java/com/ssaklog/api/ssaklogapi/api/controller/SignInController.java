package com.ssaklog.api.ssaklogapi.api.controller;

import com.ssaklog.api.ssaklogapi.api.dto.SignInRequest;
import com.ssaklog.api.ssaklogapi.api.entity.common.CommonResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "signInController")
@RequestMapping("/api/sign-in")
public class SignInController {

    @ApiOperation(value = "로그인", notes = "id와 pwd 입")
    @PostMapping("")
    public CommonResponse signIn(SignInRequest request) {
        return new CommonResponse();
    }
}
