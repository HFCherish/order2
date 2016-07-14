package com.thoughtworks.order.infrastructure.repositories.impl;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.infrastructure.repositories.OrderRepository;

import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void save(Order order) {

    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(new Order());
    }
}
