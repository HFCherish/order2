package com.thoughtworks.order.domain;

import com.thoughtworks.order.infrastructure.records.Record;
import com.thoughtworks.order.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User extends AssertionConcern implements Record {
    private String id;
    private String name;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("id", getId());
            put("name", getName());
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }

    public String getId() {
        return id;
    }
}
