package com.ssaklog.api.ssaklogapi.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(value = "회원가입 요구 정보")
public class AddUserRequest {

    @ApiModelProperty(value = "아이디")
    private String userId;

    @ApiModelProperty(value = "비밀번호")
    private String password;

    @ApiModelProperty(value = "비밀번호 재확인 값")
    private String checkPassword;

    @ApiModelProperty(value = "이름")
    private String userName;

    @ApiModelProperty(value = "생년월일")
    private String birthDate;

    @ApiModelProperty(value = "이메일")
    private String email;

}
