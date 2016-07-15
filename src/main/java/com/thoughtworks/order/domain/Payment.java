package com.thoughtworks.order.domain;

import com.thoughtworks.order.infrastructure.records.Record;
import com.thoughtworks.order.web.jersey.Routes;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

public class Payment implements Record {
    private String orderId;
    private double amount;
    private PayType type;
    private DateTime payAt;

    public Payment(String orderId, PayType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.orderId = orderId;
    }

    public Payment() {

    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type.name();
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("pay_type", type);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
