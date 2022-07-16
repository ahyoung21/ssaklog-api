package com.ssaklog.api.ssaklogapi.api.exception;

import com.ssaklog.api.ssaklogapi.api.enums.ErrorCode;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private ErrorResponseMeta meta;

    public ErrorResponse(ErrorCode errorCode) {
        this.meta = new ErrorResponseMeta(errorCode);
    }

    public ErrorResponse(int code, String message) {
        this.meta = new ErrorResponseMeta(code, message);
    }

}
