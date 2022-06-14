package com.ssaklog.api.ssaklogapi.api.exception;

import com.ssaklog.api.ssaklogapi.api.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;
}
