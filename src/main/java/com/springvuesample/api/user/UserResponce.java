package com.springvuesample.api.user;

import java.util.List;

import com.springvuesample.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponce {

    private List<User> users;
}