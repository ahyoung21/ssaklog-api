package com.ssaklog.api.ssaklogapi.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
@Setter
@ApiModel(value = "게시글 목록 조회 Response")
public class ListPostResponse {

    @ApiModelProperty(value = "게시글 번호")
    private int postSeq;

    @ApiModelProperty(value = "유저 시퀀스")
    private int userSeq;

    @ApiModelProperty(value = "제목")
    private String title;

    @ApiModelProperty(value = "본문")
    private String contents;

    @ApiModelProperty(value = "조회수")
    private int viewCount;

    @ApiModelProperty(value = "등록일시", example = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerDate;

    @ApiModelProperty(value = "수정일시", example = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;
}
