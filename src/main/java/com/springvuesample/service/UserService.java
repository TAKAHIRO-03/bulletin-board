package com.springvuesample.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Collections;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.domain.User;
import com.springvuesample.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {

        val users = this.userRepository.findAll();

        if (CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }

        return users;
    }

    public User findById(final String id) {
        return this.userRepository.findById(StringToLongConverter.parseIdParam(id)).orElseThrow(IllegalArgumentException::new);
    }

    public void create(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    public void update(final String id, final User user) throws EntityNotFoundException, IllegalArgumentException {
        val registedUser = this.userRepository.getOne(StringToLongConverter.parseIdParam(id));

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
        this.userRepository.deleteById(StringToLongConverter.parseIdParam(id));
    }

    /**
     * 
     * 更新用
     * 
     */
    public User getOne(final Long id){
        return this.userRepository.getOne(id);
    }

}
