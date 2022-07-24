package com.ssaklog.api.ssaklogapi.api.exception;


import com.ssaklog.api.ssaklogapi.api.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;

    private final int code;

    private final String message;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.code = 0;
        this.message = "";
    }

    public CustomException(int code, String message) {
        this.errorCode = null;
        this.code = code;
        this.message = message;
    }
}
