package com.ssaklog.api.ssaklogapi.api.service;

import com.ssaklog.api.ssaklogapi.api.converter.PostConverter;
import com.ssaklog.api.ssaklogapi.api.dto.*;
import com.ssaklog.api.ssaklogapi.api.entity.Post;
import com.ssaklog.api.ssaklogapi.api.enums.DeleteYnEnum;
import com.ssaklog.api.ssaklogapi.api.enums.ErrorCode;
import com.ssaklog.api.ssaklogapi.api.exception.CustomException;
import com.ssaklog.api.ssaklogapi.api.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostConverter postConverter;

    private final int USER_SEQ = 4; // 임시 (guest 유저)

    public Post getPost(int postSeq) {
        return getPostByPostSeqAndDeleteYn(postSeq, DeleteYnEnum.N.getCode());
    }

    public Post getPostByPostSeqAndDeleteYn(int postSeq, String deleteYn) {
        return postRepository.findByPostSeqAndDeleteYn(postSeq, deleteYn).orElse(null);
    }

    public List<Post> getPostsByDeleteYn(String deleteYn) {
        return postRepository.findAllByDeleteYnOrderByPostSeqDesc(deleteYn);
    }

    public List<ListPostResponse> listPost(ListPostRequest request) {

        // TODO : 페이징
        List<Post> posts = getPostsByDeleteYn(DeleteYnEnum.N.getCode());
        return postConverter.toListPostResponse(posts);
    }

    /**
     * 게시글 상세 조회
     *
     * @param request
     * @return
     */
    public DetailPostResponse detailPost(DetailPostRequest request) {
        Post post = getPost(request.getPostSeq());
        if (isExist(post)) {
            return postConverter.toDetailPostResponse(post);
        }
        return null;
    }

    /**
     * 게시글 등록
     *
     * @param request
     * @return
     */
    @Transactional
    public Integer addPost(AddPostRequest request) {
        int userSeq = USER_SEQ; // 임시 (guest 유저)

        validateAddPost(request);
        Post post = postConverter.toAddEntity(request, userSeq);
        return postRepository.save(post).getPostSeq();
    }

    /**
     * 게시글 등록 유효성 체크
     *
     * @param request
     */
    private void validateAddPost(AddPostRequest request) {
        isNotEmptyTitle(request.getTitle());
        isNotEmptyContents(request.getContents());
        isNotExceededTitle(request.getTitle());
    }

    /**
     * 게시글 수정
     *
     * @param request
     * @return
     */
    @Transactional
    public boolean modifyPost(ModifyPostRequest request) {
        int userSeq = USER_SEQ; // 임시 (guest 유저)

        Post post = getPost(request.getPostSeq());
        validateModifyPost(post, request, userSeq);

        post.modify(request.getTitle(), request.getContents());
        return true;
    }

    /**
     * 게시글 수정 유효성 체크
     *
     * @param post
     * @param request
     * @param userSeq
     */
    private void validateModifyPost(Post post, ModifyPostRequest request, int userSeq) {
        isExist(post);
        isNotMatchUser(post.getUserSeq(), userSeq);
        isNotEmptyTitle(request.getTitle());
        isNotEmptyContents(request.getContents());
        isNotExceededTitle(request.getTitle());
    }

    /**
     * 게시글 삭제
     *
     * @param request
     * @return
     */
    @Transactional
    public boolean removePost(RemovePostRequest request) {
        int userSeq = USER_SEQ; // 임시 (guest 유저)

        Post post = getPost(request.getPostSeq());
        validateRemovePost(post, userSeq);

        post.remove();
        return true;
    }

    /**
     * 게시글 삭제 유효성 체크
     *
     * @param post
     * @param userSeq
     */
    private void validateRemovePost(Post post, int userSeq) {
        isExist(post);
        isNotMatchUser(post.getUserSeq(), userSeq);
    }

    /**
     * 게시글 존재 체크
     *
     * @param post
     * @return
     */
    private boolean isExist(Post post) {
        if (!Optional.ofNullable(post).isPresent()) {
            throw new CustomException(ErrorCode.NOT_EXIST_POST);
        }
        return true;
    }

    /**
     * 작성자, 요청자 일치 여부 체크
     *
     * @param postUserSeq
     * @return
     */
    private boolean isNotMatchUser(int postUserSeq, int userSeq) {
        if (postUserSeq != userSeq) {
            throw new CustomException(ErrorCode.NOT_MATCH_POST_USER);
        }
        return true;
    }

    /**
     * 제목 빈 값 체크
     *
     * @param title
     * @return
     */
    private boolean isNotEmptyTitle(String title) {
        if (!Optional.ofNullable(title).isPresent()) {
            throw new CustomException(ErrorCode.EMPTY_POST_TITLE);
        }
        return true;
    }

    /**
     * 본문 빈 값 체크
     *
     * @param title
     * @return
     */
    private boolean isNotEmptyContents(String title) {
        if (!Optional.ofNullable(title).isPresent()) {
            throw new CustomException(ErrorCode.EMPTY_POST_CONTENTS);
        }
        return true;
    }

    /**
     * 제목 글자수 초과 체크
     *
     * @param title
     * @return
     */
    private boolean isNotExceededTitle(String title) {
        if (title != null && title.length() > 30) {
            throw new CustomException(ErrorCode.EXCEEDED_POST_TITLE);
        }
        return true;
    }
}