package com.thoughtworks.order.domain;

import com.thoughtworks.order.infrastructure.records.Record;
import com.thoughtworks.order.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Product implements Record {
    String id;
    String name;
    String description;
    double price;

    public Product() {
        this.id = UUID.randomUUID().toString();
    }

    public Product(String name, String description, double price) {
        this();
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
        return id;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("id", getId());
            put("uri", routes.productUrl(Product.this));
            put("name", getName());
            put("description", getDescription());
            put("price", getPrice());
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
