package com.thoughtworks.order.web.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.order.domain.OrderItem;
import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;

import javax.inject.Inject;
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
