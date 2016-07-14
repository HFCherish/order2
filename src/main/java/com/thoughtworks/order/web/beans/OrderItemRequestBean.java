package com.thoughtworks.order.web.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderItemRequestBean {
    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("quantity")
    private int quantity;

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
