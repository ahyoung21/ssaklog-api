package com.ssaklog.api.ssaklogapi.api.service;

import com.ssaklog.api.ssaklogapi.api.entity.Tag;
import com.ssaklog.api.ssaklogapi.api.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "tagService")
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> listTags() {
        return tagRepository.findAll();
    }

}
