package com.thoughtworks.order.infrastructure.services;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.domain.OrderItem;
import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.web.beans.OrderItemRequestBean;
import com.thoughtworks.order.web.beans.OrderRequestBean;

public interface OrderService {
    Product canGetProduct(String productId);

    Order createOrder(User user, OrderRequestBean orderInfo);

    OrderItem createOrderItem(OrderItemRequestBean orderItemRequestBean);
}
