package com.springvuesample.api.user;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.api.EmptyJsonBody;
import com.springvuesample.domain.User;
import com.springvuesample.service.BranchService;
import com.springvuesample.service.DepartmentService;
import com.springvuesample.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.val;
import ma.glasnost.orika.MapperFactory;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BranchService branchService;
    private final DepartmentService departmentService;
    private final MapperFactory mapperFactory;

    @GetMapping
    public ResponseEntity<UserResponse> findAll() {
        val users = userService.findAll();
        val usersResponse = UserResponse.builder().users(users).build();
        return new ResponseEntity<>(usersResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final String id) {

        try {
            val user = userService.findById(id);
            val userResponse = UserResponse.builder().user(user).build();
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } catch (final IllegalArgumentException e) {
            return new ResponseEntity<>(new EmptyJsonBody(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody final UserDto dto) {

        System.out.println(dto);

        val mapper = mapperFactory.getMapperFacade(UserDto.class, User.class);
        val user = mapper.map(dto);
        user.setDepartment(departmentService.getOne(dto.getDepartment()));
        user.setBranch(branchService.getOne(dto.getBranch()));
        this.userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable final String id, @RequestBody final UserDto dto) {

        try {
            val mapper = mapperFactory.getMapperFacade(UserDto.class, User.class);
            this.userService.update(id, mapper.map(dto));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (final EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (final IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable final String id) {
        this.userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
