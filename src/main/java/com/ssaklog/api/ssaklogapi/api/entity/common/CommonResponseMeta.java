package com.ssaklog.api.ssaklogapi.api.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.InetAddress;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponseMeta {
    private int code;

    private String message;

    private String path;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    @JsonProperty("sId")
    private String sId; // 서버 IP 마지막 자리

    protected CommonResponseMeta() {

    }

    public CommonResponseMeta(int code, String message) {

        setMeta(code, message);
    }

    public CommonResponseMeta(int code, String message, String path) {

        setMeta(code, message);
        this.path = path;
    }

    public int getCode() {

        return code;
    }

    public String getMessage() {

        return message;
    }

    public String getPath() {

        return path;
    }

    public LocalDateTime getDateTime() {

        return dateTime;
    }

    private void setMeta(int code, String message) {

        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now();
        this.sId = getSid();
    }

    @Deprecated
    private String getSid() {

        String sid = "";
        try {
            String serverIp = InetAddress.getLocalHost().getHostAddress();
            String[] serverIps = serverIp.split("\\.");
            sid = serverIps[serverIps.length - 1];
        } catch (Exception ignored) {
        }
        return sid;
    }
}
