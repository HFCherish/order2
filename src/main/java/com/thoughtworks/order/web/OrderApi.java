package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.infrastructure.repositories.OrderRepository;
import com.thoughtworks.order.infrastructure.services.OrderService;
import com.thoughtworks.order.web.beans.OrderRequestBean;
import com.thoughtworks.order.web.jersey.Routes;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class OrderApi {

    private final User user;

    public OrderApi(User user) {
        this.user = user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response buildOrder(OrderRequestBean orderInfo,
                               @Context OrderRepository orderRepository,
                               @Context OrderService orderService,
                               @Context Routes routes) {
        orderRepository.save(orderService.createOrder(user, orderInfo));
        return Response.created(routes.orderUrl(user)).build();
    }
}
