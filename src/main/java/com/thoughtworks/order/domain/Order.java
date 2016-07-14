package com.thoughtworks.order.domain;

import java.util.UUID;

public class Order {
    String id;
    String userId;
    String name;
    String address;
    String phone;
    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    public Order(String name, String address, String phone, String userId) {
        this();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.userId = userId;
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
}
