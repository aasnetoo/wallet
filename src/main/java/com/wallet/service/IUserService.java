package com.wallet.service;

import com.wallet.entity.UserEntity;

import java.util.Optional;

public interface IUserService {
    public UserEntity saveUser (UserEntity user);

    public Optional<UserEntity> findByEmail(String email);

}
