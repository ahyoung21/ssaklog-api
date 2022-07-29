package com.ssaklog.api.ssaklogapi.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(value = "게시글 수정 정보 request")
public class ModifyPostRequest {

    @ApiModelProperty(value = "게시글 번호", example = "0")
    private int postSeq;

    @ApiModelProperty(value = "제목")
    private String title;

    @ApiModelProperty(value = "본문")
    private String contents;
}
