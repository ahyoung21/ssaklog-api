package com.ssaklog.api.ssaklogapi.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(value = "게시글 상세 정보 request")
public class DetailPostRequest {

    @ApiModelProperty(value = "게시글 번호", example = "0")
    private final int postSeq;

    public DetailPostRequest(int postSeq) {
        this.postSeq = postSeq;
    }
}
