package com.ssaklog.api.ssaklogapi.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 100 CONTINUE : 정보성 상태 코드 */
    TEST_ERROR(HttpStatus.CONTINUE, "ErrorCode를 통한 테스트 에러입니다."),

    /* 400 BAD_REQUEST : 잘못된 요청 */
    EMPTY_USER_ID(HttpStatus.BAD_REQUEST, "아이디를 입력해주세요."),
    EMPTY_USER_NAME(HttpStatus.BAD_REQUEST, "이름을 입력해주세요."),
    EMPTY_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호를 입력해주세요."),
    EMPTY_BIRTHDAY(HttpStatus.BAD_REQUEST, "생년월일을 입력해주세요."),
    EMPTY_EMAIL(HttpStatus.BAD_REQUEST, "이메일을 입력해주세요."),
    EMPTY_CERTIFICATE_NUMBER(HttpStatus.BAD_REQUEST, "인증번호를 입력해주세요")
    ;

    private final HttpStatus httpStatus;
    private final String message;

}
