package com.ssaklog.api.ssaklogapi.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DormantStatusEnum {
    Y("Y", "휴면"),
    N("N", "이용 중");

    private String code;
    private String value;
}
