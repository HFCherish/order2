package com.thoughtworks.order.web.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.domain.OrderItem;
import com.thoughtworks.order.domain.User;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
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
    List<OrderItemRequestBean> orderItemRequestBeans;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<OrderItemRequestBean> getOrderItemRequestBeans() {
        return orderItemRequestBeans;
    }
}
