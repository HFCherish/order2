package com.thoughtworks.order.domain;

import java.util.List;
import java.util.UUID;

public class Order {
    String id;
    String userId;
    String name;
    String address;
    String phone;
    List<OrderItem> orderItems;

    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    public Order(String name, String address, String phone, String userId, List<OrderItem> orderItems) {
        this();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.userId = userId;
        initOrderItems(orderItems);
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    private void initOrderItems(List<OrderItem> orderItems) {
        if(orderItems == null || orderItems.size() == 0 ){
            throw new IllegalArgumentException("must order at least one product.");
        }
        this.orderItems = orderItems;
    }
}
