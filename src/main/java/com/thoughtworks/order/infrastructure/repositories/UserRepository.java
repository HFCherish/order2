package com.thoughtworks.order.infrastructure.repositories;

import com.thoughtworks.order.domain.user.User;
import com.thoughtworks.order.domain.user.UserId;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> ofId(UserId id);

    User findUserByName(String userName);
}
