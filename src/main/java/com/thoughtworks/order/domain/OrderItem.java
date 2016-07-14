package com.thoughtworks.order.domain;

public class OrderItem {
    private String productId;
    private String quantity;

    public OrderItem() {
    }

    public OrderItem(String productId, String quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getQuantity() {
        return quantity;
    }
}
