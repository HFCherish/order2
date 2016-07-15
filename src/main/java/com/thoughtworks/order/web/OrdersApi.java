package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.infrastructure.repositories.OrderRepository;
import com.thoughtworks.order.infrastructure.services.OrderService;
import com.thoughtworks.order.web.beans.OrderRequestBean;
import com.thoughtworks.order.web.beans.OrdersResponseData;
import com.thoughtworks.order.web.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

public class OrdersApi {

    private final User user;

    public OrdersApi(User user) {
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

    @Path("{orderId}")
    public OrderApi getOrder(@PathParam("orderId") String orderId,
                          @Context OrderRepository orderRepository) {
        return orderRepository.findById(orderId)
                .map(OrderApi::new)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrdersResponseData> getOrder(@Context OrderRepository orderRepository) {
        return orderRepository.findAllOfUser(user.getId()).stream().map(OrdersResponseData::new).collect(Collectors.toList());
    }


}
