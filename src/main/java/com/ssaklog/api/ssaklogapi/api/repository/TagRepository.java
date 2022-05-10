package com.ssaklog.api.ssaklogapi.api.repository;

import com.ssaklog.api.ssaklogapi.api.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
}
