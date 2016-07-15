package com.thoughtworks.order.domain;

import org.joda.time.DateTime;

public class Payment {
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

    public DateTime getPayAt() {
        return payAt;
    }

    public String getOrderId() {
        return orderId;
    }
}
