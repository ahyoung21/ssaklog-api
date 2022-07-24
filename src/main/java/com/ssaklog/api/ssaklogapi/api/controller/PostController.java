package com.ssaklog.api.ssaklogapi.api.controller;

import com.ssaklog.api.ssaklogapi.api.dto.*;
import com.ssaklog.api.ssaklogapi.api.entity.common.CommonResponse;
import com.ssaklog.api.ssaklogapi.api.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController(value = "postController")
@RequestMapping("/api/post")
@RequiredArgsConstructor
@Api(tags = {"게시글 컨트롤러"})
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "게시글 목록 조회")
    @GetMapping(path = "/list")
    public CommonResponse listPost(@ApiParam("목록 조회 할 요청 정보") ListPostRequest request) {
        return new CommonResponse(postService.listPost(request));
    }

    @ApiOperation(value = "게시글 상세 조회")
    @GetMapping(path = "")
    public CommonResponse detailPost(@ApiParam("상세 조회 할 게시글 정보") DetailPostRequest request) {
        return new CommonResponse(postService.detailPost(request));
    }

    @ApiOperation(value = "게시글 등록")
    @PostMapping(path = "")
    public CommonResponse addPost(@ApiParam("등록 할 게시글 정보") @RequestBody AddPostRequest request) {
        return new CommonResponse(postService.addPost(request));
    }

    @ApiOperation(value = "게시글 수정")
    @PutMapping(path = "")
    public CommonResponse modifyPost(@ApiParam("수정 할 게시글 정보") @RequestBody ModifyPostRequest request) {
        return new CommonResponse(postService.modifyPost(request));
    }

    @ApiOperation(value = "게시글 삭제")
    @DeleteMapping(path = "")
    public CommonResponse removePost(@ApiParam("삭제 할 게시글 정보") @RequestBody RemovePostRequest request) {
        return new CommonResponse(postService.removePost(request));
    }
}