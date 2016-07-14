package com.thoughtworks.order.infrastructure.repositories.impl;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.domain.OrderItem;
import com.thoughtworks.order.infrastructure.mybatis.mappers.OrderItemMapper;
import com.thoughtworks.order.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.order.infrastructure.repositories.OrderRepository;

import javax.inject.Inject;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    @Inject
    OrderMapper orderMapper;

    @Inject
    OrderItemMapper orderItemMapper;

    @Override
    public void save(Order order) {
        orderMapper.save(order);
        for(OrderItem orderItem: order.getOrderItems()) {
            orderItemMapper.save(orderItem, order.getId());
        }
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(orderMapper.findById(id));
    }
}
