package com.ssaklog.api.ssaklogapi.api.entity.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssaklog.api.ssaklogapi.api.enums.ResponseEnum;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {

    private CommonResponseMeta meta;

    private T data;

    public CommonResponse() {

        setSuccess();
        this.data = null;
    }

    public CommonResponse(T result) {

        setSuccess();
        this.data = result;
    }

    public CommonResponse(int code, String message) {

        this.meta = new CommonResponseMeta(code, message);
        this.data = null;
    }

    public CommonResponse(int code, String message, T result) {

        this.meta = new CommonResponseMeta(code, message);
        this.data = result;
    }

    public CommonResponse(CommonResponseMeta meta) {

        this.meta = meta;
    }

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

    public CommonResponseMeta getMeta() {

        return meta;
    }

    public T getData() {

        return data;
    }

    private void setSuccess() {

        this.meta = new CommonResponseMeta(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getValue());
    }
}
