package com.thoughtworks.order.infrastructure.services.Impl;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.domain.OrderItem;
import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;
import com.thoughtworks.order.infrastructure.services.OrderService;
import com.thoughtworks.order.web.beans.OrderItemRequestBean;
import com.thoughtworks.order.web.beans.OrderRequestBean;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    @Inject
    ProductRepository productRepository;

    @Override
    public Product canGetProduct(String productId) {
        return productRepository.findById(productId)
                .map(product1 -> product1)
                .orElseThrow(() -> new IllegalArgumentException("the order item " + productId + " doesn't exist."));
    }

    @Override
    public Order createOrder(User user, OrderRequestBean orderInfo) {
        List<OrderItem> orderItems = orderInfo.getOrderItemRequestBeans().stream().map(this::createOrderItem).collect(Collectors.toList());
        return new Order(orderInfo.getName(), orderInfo.getAddress(), orderInfo.getPhone(), user.getId(), orderItems);
    }

    @Override
    public OrderItem createOrderItem(OrderItemRequestBean orderItemRequestBean){
        return new OrderItem(orderItemRequestBean.getProductId(),orderItemRequestBean.getQuantity(), canGetProduct(orderItemRequestBean.getProductId()).getPrice());
    }

}
