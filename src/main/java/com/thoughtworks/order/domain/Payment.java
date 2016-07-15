package com.thoughtworks.order.domain;

public class Payment {
    private double amount;
    private PayType type;

    public Payment(PayType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public Payment() {

    }

    public double getAmount() {
        return amount;
    }

    public PayType getType() {
        return type;
    }
}
