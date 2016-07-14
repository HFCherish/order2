package com.thoughtworks.order.domain;

import com.thoughtworks.order.domain.user.User;
import com.thoughtworks.order.infrastructure.records.Record;
import com.thoughtworks.order.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.Arrays.asList;

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
            put("uri", routes.productUrl(Product.this));
//            put("id", getUserId().id());
//            put("name", getName());
//            put("email", getEmail());
//            put("role", role);
//            put("links", asList(
//                    new HashMap<String, Object>() {{
//                        put("rel", "self");
//                        put("uri", routes.userUrl(User.this));
//                    }}
//            ));
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
