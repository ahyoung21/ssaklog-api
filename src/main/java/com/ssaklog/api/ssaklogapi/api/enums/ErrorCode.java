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
    EMPTY_CHECK_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호 확인 값을 입력해주세요."),
    EMPTY_BIRTHDAY(HttpStatus.BAD_REQUEST, "생년월일을 입력해주세요."),
    EMPTY_EMAIL(HttpStatus.BAD_REQUEST, "이메일을 입력해주세요."),
    EMPTY_CERTIFICATE_NUMBER(HttpStatus.BAD_REQUEST, "인증번호를 입력해주세요"),

    REGEX_USER_ID(HttpStatus.BAD_REQUEST, "아이디 형식이 맞지 않습니다"),
    REGEX_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호 형식이 맞지 않습니다"),
    DISCORD_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호와 비밀번호 확인값이 일치하지 않습니다."),
    REGEX_USER_NAME(HttpStatus.BAD_REQUEST, "이름 형식이 맞지 않습니다"),
    REGEX_BIRTHDATE(HttpStatus.BAD_REQUEST, "생년월일이 잘못되었습니다"),
    REGEX_EMAIL(HttpStatus.BAD_REQUEST, "이메일 형식이 올바르지 않습니다"),

    /* 409 CONFLICT : 서버와의 충돌 */
    ALREADY_EXIST_USER_ID(HttpStatus.CONFLICT, "해당 아이디가 존재합니다."),
    ALREADY_EXIST_EMAIL(HttpStatus.CONFLICT, "해당 이메일이 존재합니다.")
    ;

    private final HttpStatus httpStatus;
    private final String message;

}
