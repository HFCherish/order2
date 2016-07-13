package com.thoughtworks.order.infrastructure.records;

import com.thoughtworks.order.web.jersey.Routes;

import java.util.Map;

public interface Record {
    Map<String, Object> toRefJson(Routes routes);

    Map<String, Object> toJson(Routes routes);
}
