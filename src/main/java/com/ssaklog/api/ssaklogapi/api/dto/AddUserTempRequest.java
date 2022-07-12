package com.ssaklog.api.ssaklogapi.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(value = "임시 회원가입 요구 정보")
public class AddUserTempRequest {

    @ApiModelProperty(value = "아이디")
    private String userId;

    @ApiModelProperty(value = "비밀번호")
    private String password;
}
