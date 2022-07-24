package com.ssaklog.api.ssaklogapi.api.converter;

import com.ssaklog.api.ssaklogapi.api.dto.AddPostRequest;
import com.ssaklog.api.ssaklogapi.api.dto.DetailPostResponse;
import com.ssaklog.api.ssaklogapi.api.dto.ListPostResponse;
import com.ssaklog.api.ssaklogapi.api.entity.Post;
import com.ssaklog.api.ssaklogapi.api.enums.DeleteYnEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostConverter {

    /**
     * 게시글 목록 Entity to response
     *
     * @param posts
     * @return
     */
    public List<ListPostResponse> toListPostResponse(List<Post> posts) {
        List<ListPostResponse> responses = new ArrayList<>();
        posts.forEach(post ->
                responses.add(
                        ListPostResponse.builder()
                                .postSeq(post.getPostSeq())
                                .userSeq(post.getUserSeq())
                                .title(post.getTitle())
                                .contents(post.getContents())
                                .viewCount(post.getViewCount())
                                .registerDate(post.getRegisterDate())
                                .updateDate(post.getUpdateDate())
                                .build()
                )
        );
        return responses;
    }

    /**
     * 게시글 상세 Entity to response
     *
     * @param post
     * @return
     */
    public DetailPostResponse toDetailPostResponse(Post post) {
        DetailPostResponse response = DetailPostResponse.builder()
                .postSeq(post.getPostSeq())
                .userSeq(post.getUserSeq())
                .title(post.getTitle())
                .contents(post.getContents())
                .viewCount(post.getViewCount())
                .registerDate(post.getRegisterDate())
                .updateDate(post.getUpdateDate())
                .build();
        return response;
    }

    /**
     * 게시글 등록 request to Entity
     *
     * @param request
     * @param userSeq
     * @return
     */
    public Post toAddEntity(AddPostRequest request, int userSeq) {
        Post post = Post.builder()
                .userSeq(userSeq)
                .title(request.getTitle())
                .contents(request.getContents())
                .viewCount(0)
                .deleteYn(DeleteYnEnum.N.getCode())
                .build();
        return post;
    }
}
