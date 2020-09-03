package com.springvuesample.api.department;

import com.springvuesample.service.DepartmentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.val;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity<DepartmentResponse> findAll() {
        val departments = departmentService.findAll();
        val departmentResponse = DepartmentResponse.builder().departments(departments).build();
        return new ResponseEntity<>(departmentResponse, HttpStatus.OK);
    }

    
}
