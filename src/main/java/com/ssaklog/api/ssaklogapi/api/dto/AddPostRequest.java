package com.ssaklog.api.ssaklogapi.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(value = "게시글 등록 정보 request")
public class AddPostRequest {

    @ApiModelProperty(value = "제목")
    private String title;

    @ApiModelProperty(value = "본문")
    private String contents;
}
