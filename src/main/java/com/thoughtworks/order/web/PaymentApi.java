package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.domain.PayType;
import com.thoughtworks.order.domain.Payment;
import com.thoughtworks.order.web.beans.PaymentResponseData;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.net.URI;

public class PaymentApi {
    private Order order;

    public PaymentApi(Order order) {
        this.order = order;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response pay() {
        return Response.created(URI.create("")).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaymentResponseData getPay(@Context UriInfo uriInfo) {
        return new PaymentResponseData(new Payment(order.getId(), PayType.CASH, 100), uriInfo);
    }
}
