package com.wallet.service.impl;

import com.wallet.entity.UserEntity;
import com.wallet.repository.UserRepository;
import com.wallet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmailEquals(email);
    }
}
