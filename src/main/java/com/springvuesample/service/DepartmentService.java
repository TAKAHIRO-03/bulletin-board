package com.springvuesample.service;

import java.util.List;

import com.springvuesample.domain.Department;
import com.springvuesample.repository.DepartmentRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return this.departmentRepository.findAll();
    }

    /**
     * 読み取り用
     * @param id
     * @return
     */
    public Department findById(final Long id) {
        return this.departmentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * 更新用
     * @param id
     * @return
     */
    public Department getOne(final Long id) {
        return this.departmentRepository.getOne(id);
    }

}
