package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;
import com.thoughtworks.order.web.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("products")
public class ProductApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> prodInfo,
                           @Context Routes routes,
                           @Context ProductRepository productRepository) {
        Product product = new Product(prodInfo.get("name").toString(), prodInfo.get("description").toString(), (double) prodInfo.get("price"));

        productRepository.save(product);
        return Response.created(routes.productUrl()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAll(@Context ProductRepository productRepository) {
        return productRepository.findAll();
    }

    @GET
    @Path("{prodId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("prodId") String prodId,
                              @Context ProductRepository productRepository) {
        return productRepository.findById(prodId)
                .map(product -> product)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }
}
