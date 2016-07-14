package com.thoughtworks.order.infrastructure.repositories;

import com.thoughtworks.order.domain.Order;

import java.util.Optional;

public interface OrderRepository {
    void save(Order order);

    Optional<Order> findById(String id);
}
