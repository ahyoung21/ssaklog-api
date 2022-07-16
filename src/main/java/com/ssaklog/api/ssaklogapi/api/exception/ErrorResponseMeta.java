package com.ssaklog.api.ssaklogapi.api.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssaklog.api.ssaklogapi.api.enums.ErrorCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponseMeta {

    // TODO : 일단 CommonResponseMeta 형식 맞춤
    private int code;

    private String error;

    private String message;

    private String path;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    protected ErrorResponseMeta() {}

    public ErrorResponseMeta(int code, String message) {
        this.code = code;
        this.error = "";
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }

    public ErrorResponseMeta(ErrorCode errorCode) {
        this.code = errorCode.getHttpStatus().value();
        this.error = errorCode.getHttpStatus().name();
        this.message = errorCode.getMessage();
        this.dateTime = LocalDateTime.now();
    }
}
