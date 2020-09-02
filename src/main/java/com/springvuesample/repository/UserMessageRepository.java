package com.springvuesample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springvuesample.domain.UserMessage;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

}