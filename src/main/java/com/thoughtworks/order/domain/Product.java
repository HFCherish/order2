package com.thoughtworks.order.domain;

import java.util.UUID;

public class Product {
    String name;
    String description;
    double price;

    public Product() {
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return UUID.randomUUID().toString();
    }
}
