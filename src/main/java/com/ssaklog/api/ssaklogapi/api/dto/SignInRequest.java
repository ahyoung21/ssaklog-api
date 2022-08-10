package com.ssaklog.api.ssaklogapi.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(value = "로그인 request")
public class SignInRequest {

    @ApiModelProperty(value = "아이디", required = true)
    private String userId;

    @ApiModelProperty(value = "비밀번호", required = true)
    private String password;

}
