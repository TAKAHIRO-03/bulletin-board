package com.springvuesample.service;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.domain.User;
import com.springvuesample.repository.UserRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(final String id) {
        return this.userRepository.findById(parseIdParam(id)).orElseThrow(IllegalArgumentException::new);
    }

    public void create(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    public void update(final String id, final User user) throws EntityNotFoundException, IllegalArgumentException {
        val registedUser = this.userRepository.getOne(parseIdParam(id));

        if (!passwordEncoder.matches(user.getPassword(), registedUser.getPassword())) {
            registedUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        registedUser.setAccount(user.getAccount());
        registedUser.setName(user.getName());
        registedUser.setBranch(user.getBranch());
        registedUser.setDepartment(user.getDepartment());
        registedUser.setIsStopped(user.getIsStopped());
        registedUser.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        this.userRepository.save(registedUser);
    }

    public void deleteById(final String id) {
        this.userRepository.deleteById(parseIdParam(id));
    }

    private Long parseIdParam(final String pathId) throws IllegalArgumentException {
        if (!pathId.matches("^[0-9]*$") || StringUtils.isBlank(pathId)) {
            throw new IllegalArgumentException();
        }

        return Long.valueOf(pathId);
    }

}
