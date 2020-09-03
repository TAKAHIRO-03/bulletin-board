package com.springvuesample.api.branch;

import com.springvuesample.service.BranchService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.val;

@RestController
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @GetMapping("/branches")
    public ResponseEntity<BranchResponse> findAll() {
        val branches = branchService.findAll();
        val branchResponse = BranchResponse.builder().branches(branches).build();
        return new ResponseEntity<>(branchResponse, HttpStatus.OK);
    }

    
}
