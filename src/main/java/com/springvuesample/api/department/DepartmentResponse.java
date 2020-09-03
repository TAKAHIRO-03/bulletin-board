package com.springvuesample.api.department;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springvuesample.domain.Department;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DepartmentResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Department> departments;

}