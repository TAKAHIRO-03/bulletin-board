package com.springvuesample.api.branch;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springvuesample.domain.Branch;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BranchResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Branch> branches;

}