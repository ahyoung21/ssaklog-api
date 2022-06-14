package com.ssaklog.api.ssaklogapi.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    EMPTY_USER_ID(HttpStatus.BAD_REQUEST, "아이디를 입력해주세요.");

    private final HttpStatus httpStatus;
    private final String message;

}
