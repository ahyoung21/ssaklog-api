package com.ssaklog.api.ssaklogapi.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "아이디 중복 체크 요구 정보")
public class CheckUserOverlapIdRequest {

    @ApiModelProperty(value = "중복 체크할 회원 아이디", required = true)
    private String userId;
}
