package com.springvuesample.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.domain.Department;
import com.springvuesample.repository.DepartmentRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class DepartmentService extends TemplateService<Department> {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Department findById(final Long id) {
        return this.departmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Department getOne(final Long id) throws EntityNotFoundException {
        return this.departmentRepository.getOne(id);
    }

    @Override
    public void create(final Department entity) {
        this.departmentRepository.save(entity);
    }

    @Override
    public void update(final Long id, final Department department) throws EntityNotFoundException {
        val registedDepartment = this.departmentRepository.getOne(id);
        registedDepartment.setName(department.getName());
        registedDepartment.setUpdatedDate(department.getUpdatedDate());
        this.departmentRepository.save(registedDepartment);
    }

    @Override
    public void deleteById(final Long id) {
        this.departmentRepository.deleteById(id);
    }

}
