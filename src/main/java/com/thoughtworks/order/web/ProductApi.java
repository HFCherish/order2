package com.thoughtworks.order.web;

import com.thoughtworks.order.infrastructure.repositories.ProductRepository;
import com.thoughtworks.order.web.jersey.Routes;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("products")
public class ProductApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> prodInfo,
                           @Context Routes routes,
                           @Context ProductRepository productRepository) {
        return Response.created(routes.productUrl()).build();
    }
}
