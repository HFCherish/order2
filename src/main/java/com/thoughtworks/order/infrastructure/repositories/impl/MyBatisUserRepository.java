package com.thoughtworks.order.infrastructure.repositories.impl;

import com.thoughtworks.order.domain.user.User;
import com.thoughtworks.order.domain.user.UserId;
import com.thoughtworks.order.infrastructure.mybatis.mappers.UserMapper;
import com.thoughtworks.order.infrastructure.repositories.UserRepository;

import javax.inject.Inject;
import java.util.Optional;

public class MyBatisUserRepository implements UserRepository {
    @Inject
    UserMapper mapper;

    @Override
    public com.thoughtworks.order.domain.user.User save(com.thoughtworks.order.domain.user.User user) {
        mapper.save(user);
        return mapper.ofId(user.getUserId().id());
    }

    @Override
    public Optional<com.thoughtworks.order.domain.user.User> ofId(UserId id) {
        return Optional.ofNullable(mapper.ofId(id.id()));
    }

    @Override
    public User findUserByName(String userName) {
        return mapper.findByUserName(userName);
    }
}
