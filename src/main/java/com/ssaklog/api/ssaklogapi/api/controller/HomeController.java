package com.ssaklog.api.ssaklogapi.api.controller;

import com.ssaklog.api.ssaklogapi.api.entity.common.CommonResponse;
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
    @GetMapping("/check/returnResponse")
    public CommonResponse checkReturnResponse() {
        return new CommonResponse();
    }

}
