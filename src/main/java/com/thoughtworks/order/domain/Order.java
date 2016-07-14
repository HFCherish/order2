package com.thoughtworks.order.domain;

import com.thoughtworks.order.infrastructure.records.Record;
import com.thoughtworks.order.web.jersey.Routes;
import org.joda.time.DateTime;

import java.util.*;

public class Order implements Record{
    DateTime createdAt;
    String id;
    String userId;
    String name;
    String address;
    String phone;
    List<OrderItem> orderItems;
    private double totalPrice;

    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    public Order(String name, String address, String phone, String userId, List<OrderItem> orderItems) {
        this();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.userId = userId;
        initOrderItems(orderItems);
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    private void initOrderItems(List<OrderItem> orderItems) {
        if(orderItems == null || orderItems.size() == 0 ){
            throw new IllegalArgumentException("must order at least one product.");
        }
        this.orderItems = orderItems;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        List orderItemsInfo = new ArrayList();
        for(OrderItem orderItem: orderItems) {
            orderItemsInfo.add(orderItem.toJson(routes));
        }

        return new HashMap<String, Object>() {{
            put("uri", routes.orderUrl(Order.this));
            put("name", name);
            put("address", address);
            put("phone", phone);
            put("total_price", totalPrice);
            put("created_at", createdAt);
            put("order_items", orderItemsInfo);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }

    public double getTotalPrice() {
        totalPrice = 0;
        for(OrderItem orderItem: orderItems) {
            totalPrice += orderItem.getAmount() * orderItem.getQuantity();
        }
        return totalPrice;
    }
}
