package com.ssaklog.api.ssaklogapi.api.controller;

import com.ssaklog.api.ssaklogapi.api.entity.common.CommonResponse;
import com.ssaklog.api.ssaklogapi.api.enums.ErrorCode;
import com.ssaklog.api.ssaklogapi.api.exception.ErrorResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello !!NEW!! SsakLog";
    }

    @ApiOperation(value = "리턴 값 확인용", notes = "리턴 response 형식 체크용입니다")
    @GetMapping("/check/return-response")
    public CommonResponse checkReturnResponse() {
        return new CommonResponse();
    }

    @ApiOperation(value = "리턴 값 확인용 (에러 - 에러 코드)", notes = "오류 리턴 response 형식 체크용입니다 (errorCode로 리턴 시)")
    @GetMapping("/check/error/error-code")
    public ErrorResponse returnErrorResponseByErrorCode() {
        return new ErrorResponse(ErrorCode.TEST_ERROR);
    }

    @ApiOperation(value = "리턴 값 확인용 (에러 - 코드, 메세지)", notes = "오류 리턴 response 형식 체크용입니다 (code, message로 리턴 시)")
    @GetMapping("/check/error/code-message")
    public ErrorResponse returnErrorResponseByCodeAndMessage() {
        return new ErrorResponse(100, "code와 message를 통한 테스트 에러입니다.");
    }

}
