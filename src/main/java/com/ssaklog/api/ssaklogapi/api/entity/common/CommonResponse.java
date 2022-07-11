package com.ssaklog.api.ssaklogapi.api.entity.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssaklog.api.ssaklogapi.api.enums.ResponseEnum;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse {
    private CommonResponseMeta meta;
    private Object data;

    public static CommonResponse fail() {
        return new CommonResponse(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getValue());
    }

    public static CommonResponse failOf(String errorMessage) {
        return new CommonResponse(ResponseEnum.FAIL.getCode(), errorMessage);
    }

    public static CommonResponse failOf(int code, String errorMessage) {
        return new CommonResponse(code, errorMessage);
    }

    public static CommonResponse failOf(String errorMessage, String path) {
        return new CommonResponse(new CommonResponseMeta(ResponseEnum.FAIL.getCode(), errorMessage, path));
    }

    public static CommonResponse failOf(int code, String errorMessage, String path) {
        return new CommonResponse(new CommonResponseMeta(code, errorMessage, path));
    }

    public CommonResponse() {
        setSuccess();
        this.data = new EmptyResult();
    }

    public CommonResponse(Object result) {
        setSuccess();
        this.data = result;
    }

    public CommonResponse(int code, String message) {
        this.meta = new CommonResponseMeta(code, message);
        this.data = new EmptyResult();
    }

    public CommonResponse(int code, String message, Object result) {
        this.meta = new CommonResponseMeta(code, message);
        this.data = result;
    }

    public CommonResponse(CommonResponseMeta meta, Object data) {
        this.meta = meta;
        this.data = data;
    }

    public CommonResponse(CommonResponseMeta meta) {
        this.meta = meta;
    }

    private void setSuccess() {
        this.meta = new CommonResponseMeta(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getValue());
    }
}
