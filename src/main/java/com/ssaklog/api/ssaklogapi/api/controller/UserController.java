package com.ssaklog.api.ssaklogapi.api.controller;

import com.ssaklog.api.ssaklogapi.api.dto.AddUserRequest;
import com.ssaklog.api.ssaklogapi.api.dto.AddUserTempRequest;
import com.ssaklog.api.ssaklogapi.api.dto.CheckUserOverlapIdRequest;
import com.ssaklog.api.ssaklogapi.api.entity.User;
import com.ssaklog.api.ssaklogapi.api.entity.common.CommonResponse;
import com.ssaklog.api.ssaklogapi.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "userController")
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Api(tags = {"회원"})
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "임시 회원가입", notes = "정식 회원가입 외에 임시로 회원을 생성할 수 있다.")
    @PostMapping("/temp-sign-up")
    public ResponseEntity<User> tempSignUp(@RequestBody AddUserTempRequest request) {
        return ResponseEntity.ok(userService.tempAdd(request));
    }

    @ApiOperation(value = "아이디 중복 체크", notes = "아이디를 입력하여 중복 체크를 진행한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "사용 가능"),
            @ApiResponse(code = -1, message = "아이디 중복"),
            @ApiResponse(code = 500, message = "오류 발생") // TODO : 구분 필요?
    })
    @GetMapping("/check-overlap-id")
    public CommonResponse checkOverlapId(CheckUserOverlapIdRequest request) {
        if (userService.checkOverlapId(request)) {
            return new CommonResponse();
        }
        return CommonResponse.failOf("아이디가 존재합니다");
    }

    @ApiOperation(value = "회원가입", notes = "실제 회원가입을 진행한다. (아직 사용 x)")
    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody AddUserRequest request) {
        return ResponseEntity.ok(userService.add(request));
    }
}
