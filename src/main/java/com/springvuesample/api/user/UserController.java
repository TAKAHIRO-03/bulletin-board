package com.springvuesample.api.user;

import com.springvuesample.domain.User;
import com.springvuesample.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.val;
import ma.glasnost.orika.MapperFactory;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MapperFactory mapperFactory;

    @GetMapping("/user")
    public ResponseEntity<UserResponse> findAll() {
        val users = userService.findAll();
        val userResponse = UserResponse.builder().users(users).build();
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<HttpStatus> save(@RequestBody UserAddRequest request) {
        val mapper = mapperFactory.getMapperFacade(UserAddRequest.class, User.class);
        this.userService.create(mapper.map(request));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        this.userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
