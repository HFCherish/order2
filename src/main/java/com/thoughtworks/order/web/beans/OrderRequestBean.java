package com.thoughtworks.order.web.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.order.domain.Order;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class OrderRequestBean {
    @JsonProperty("name")
    String name;

    @JsonProperty("address")
    String address;

    @JsonProperty("phone")
    String phone;

    @JsonProperty("order_items")
    List<OrderItemRequestBean> orderItems;

    public Order createOrder() {
        return new Order(name, address, phone);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<OrderItemRequestBean> getOrderItems() {
        return orderItems;
    }
}
