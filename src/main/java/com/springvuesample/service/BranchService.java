package com.springvuesample.service;

import java.util.List;

import com.springvuesample.domain.Branch;
import com.springvuesample.repository.BranchRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;

    public List<Branch> findAll() {
        return this.branchRepository.findAll();
    }

    /**
     * 読み取り用
     * @param id
     * @return
     */
    public Branch findById(final Long id) {
        return this.branchRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * 更新用
     * @param id
     * @return
     */
    public Branch getOne(final Long id) {
        return this.branchRepository.getOne(id);
    }

}
