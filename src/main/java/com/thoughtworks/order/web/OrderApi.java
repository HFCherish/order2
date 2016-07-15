package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.Order;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class OrderApi {
    private Order order;

    public OrderApi(Order order) {
        this.order = order;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder() {
        return order;
    }

    @Path("payment")
    public PaymentApi toPaymentApi() {
        return new PaymentApi(order);
    }
}
