package com.ssaklog.api.ssaklogapi.api.controller;

import com.ssaklog.api.ssaklogapi.api.entity.Tag;
import com.ssaklog.api.ssaklogapi.api.service.TagService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "tagController")
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @ApiOperation(value = "태그 정보 리스트 조회", response = Tag.class, responseContainer = "List")
    @GetMapping("/list")
    public List<Tag> list() {
        List<Tag> list = tagService.listTags(); // 디버깅을 위해 분리
        return list;
    }

}
