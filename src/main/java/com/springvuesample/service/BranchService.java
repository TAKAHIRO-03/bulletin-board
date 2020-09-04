package com.springvuesample.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.domain.Branch;
import com.springvuesample.repository.BranchRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class BranchService extends TemplateService<Branch> {

    private final BranchRepository branchRepository;

    @Override
    public List<Branch> findAll() {
        return this.branchRepository.findAll();
    }

    @Override
    public Branch findById(final Long id) throws EntityNotFoundException {
        return this.branchRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Branch getOne(final Long id) throws EntityNotFoundException {
        return this.branchRepository.getOne(id);
    }

    @Override
    public void create(final Branch branch) {
        this.branchRepository.save(branch);
    }

    @Override
    public void update(final Long id, final Branch branch) throws EntityNotFoundException {
        val registedBranch = this.branchRepository.getOne(id);
        registedBranch.setName(branch.getName());
        registedBranch.setUpdatedDate(branch.getUpdatedDate());
        this.branchRepository.save(registedBranch);
    }

    @Override
    public void deleteById(final Long id) {
        this.branchRepository.deleteById(id);
    }

}
