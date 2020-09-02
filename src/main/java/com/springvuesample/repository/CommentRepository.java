package com.springvuesample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springvuesample.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
