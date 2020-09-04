package com.springvuesample.service;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.springvuesample.domain.User;
import com.springvuesample.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class UserService extends TemplateService<User> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(final Long id) {
        return this.userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void create(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public void update(final Long id, final User user) throws EntityNotFoundException {
        val registedUser = this.userRepository.getOne(id);

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

    @Override
    public void deleteById(final Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User getOne(final Long id) throws EntityNotFoundException {
        return this.userRepository.getOne(id);
    }

}
