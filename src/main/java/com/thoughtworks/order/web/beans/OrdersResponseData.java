package com.thoughtworks.order.web.beans;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.infrastructure.records.Record;
import com.thoughtworks.order.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class OrdersResponseData implements Record {
    private Order order;

    public OrdersResponseData(Order order) {
        this.order = order;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("uri", routes.orderUrl(order));
            put("name", order.getName());
            put("address", order.getAddress());
            put("phone", order.getPhone());
            put("total_price", order.getTotalPrice());
            put("created_at", order.getCreatedAt());
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
