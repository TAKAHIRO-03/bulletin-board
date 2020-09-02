package com.springvuesample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springvuesample.domain.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

}
