package com.ssaklog.api.ssaklogapi.api.repository;

import com.ssaklog.api.ssaklogapi.api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Optional<Post> findByPostSeqAndDeleteYn(int postSeq, String deleteYn);

    List<Post> findAllByDeleteYnOrderByPostSeqDesc(String deleteYn);
}
