package com.springvuesample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springvuesample.domain.UserComment;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Long> {

}