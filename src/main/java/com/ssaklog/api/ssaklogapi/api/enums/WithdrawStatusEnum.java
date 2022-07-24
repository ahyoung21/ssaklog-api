package com.ssaklog.api.ssaklogapi.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WithdrawStatusEnum {
    Y("Y", "탈퇴"),
    N("N", "이용 중");

    private String code;
    private String value;
}
