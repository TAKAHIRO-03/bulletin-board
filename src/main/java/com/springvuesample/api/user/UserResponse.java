package com.springvuesample.api.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springvuesample.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final User user;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<User> users;

}