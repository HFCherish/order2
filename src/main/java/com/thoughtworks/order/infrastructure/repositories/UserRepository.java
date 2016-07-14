package com.thoughtworks.order.infrastructure.repositories;

import com.thoughtworks.order.domain.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> findById(String id);
}
