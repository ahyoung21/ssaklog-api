package com.ssaklog.api.ssaklogapi.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeleteYnEnum {
    Y("Y", "삭제"),
    N("N", "미삭제");

    private String code;
    private String value;
}
