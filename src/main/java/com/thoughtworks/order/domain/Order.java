package com.thoughtworks.order.domain;

import java.util.UUID;

public class Order {
    String id;
    String name;
    String address;
    String phone;
    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    public Order(String name, String address, String phone) {
        this();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }
}
