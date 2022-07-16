package com.ssaklog.api.ssaklogapi.api.config.exception;

import com.ssaklog.api.ssaklogapi.api.exception.CustomException;
import com.ssaklog.api.ssaklogapi.api.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { CustomException.class })
    protected ErrorResponse handleCustomException(CustomException e) {
        if (!Optional.ofNullable(e.getErrorCode()).isEmpty()) {
            return new ErrorResponse(e.getErrorCode());
        } else {
            return new ErrorResponse(e.getCode(), e.getMessage());
        }
    }
}
