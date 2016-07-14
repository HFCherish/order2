package com.thoughtworks.order.infrastructure.repositories.impl;

import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.infrastructure.mybatis.mappers.UserMapper;
import com.thoughtworks.order.infrastructure.repositories.UserRepository;

import javax.inject.Inject;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Inject
    UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMapper.findById(id));
    }
}
