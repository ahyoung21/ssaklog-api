package com.ssaklog.api.ssaklogapi.api.controller;

import com.ssaklog.api.ssaklogapi.api.dto.UserAddRequest;
import com.ssaklog.api.ssaklogapi.api.dto.UserTempAddRequest;
import com.ssaklog.api.ssaklogapi.api.entity.User;
import com.ssaklog.api.ssaklogapi.api.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "userController")
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "임시 회원가입", notes = "정식 회원가입 외에 임시로 회원을 생성할 수 있다.")
    @PostMapping("/temp-sign-up")
    public ResponseEntity<User> tempSignUp(@RequestBody UserTempAddRequest request) {
        return ResponseEntity.ok(userService.tempAdd(request));
    }

    @ApiOperation(value = "회원가입", notes = "실제 회원가입을 진행한다.")
    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody UserAddRequest request) {
        return ResponseEntity.ok(userService.add(request));
    }
}
