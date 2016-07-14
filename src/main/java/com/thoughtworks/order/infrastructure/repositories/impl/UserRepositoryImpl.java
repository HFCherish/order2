package com.thoughtworks.order.infrastructure.repositories.impl;

import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.infrastructure.repositories.UserRepository;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(User user) {

    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(new User());
    }
}
