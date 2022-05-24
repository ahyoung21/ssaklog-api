package com.ssaklog.api.ssaklogapi.api.repository;

import com.ssaklog.api.ssaklogapi.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
