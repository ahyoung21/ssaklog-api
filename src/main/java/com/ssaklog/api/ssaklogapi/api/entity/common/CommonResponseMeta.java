package com.ssaklog.api.ssaklogapi.api.entity.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponseMeta {
    private int code;
    private String message;
    private String path;
    private LocalDateTime dateTime;

    @JsonProperty("sId")
    private String sId; // 서버 IP 마지막 자리

    public CommonResponseMeta(int code, String message) {
        setMeta(code, message);
    }

    public CommonResponseMeta(int code, String message, String path) {
        setMeta(code, message);
        this.path = path;
    }

    @JsonCreator
    public CommonResponseMeta(
            @JsonProperty("code") int code,
            @JsonProperty("message") String message,
            @JsonProperty("dateTime") String dateTime,
            @JsonProperty("path") String path,
            @JsonProperty("sId") String sId) {
        this.code = code;
        this.message = message;
        this.path = path;
        this.dateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.sId = sId;
    }

    private void setMeta(int code, String message) {
        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now();
        this.sId = getSid();
    }

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
