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
        initName(name);
    }

    private void initName(String name) {
        if( !isValidName(name) ) {
            throw new IllegalArgumentException("the name can only be composed of letters and numbers.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    private boolean isValidName(String name) {
        return name.matches("^[A-Za-z0-9]+$");
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
}
