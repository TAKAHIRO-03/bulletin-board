package com.springvuesample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springvuesample.domain.UserBranchDepartment;

@Repository
public interface UserBranchDepartmentRepository extends JpaRepository<UserBranchDepartment, Long> {
    
}
