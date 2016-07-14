package com.thoughtworks.order.web.jersey;

import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.domain.User;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class Routes {

    private final String baseUri;

    public Routes(UriInfo uriInfo) {
        baseUri = uriInfo.getBaseUri().toASCIIString();
    }

    public URI userUrl(User user) {
        return URI.create(baseUri + "users/" + user.getId());
    }

    public URI userUrl() {
        return URI.create(baseUri + "users/");
    }

    public URI productUrl() {
        return URI.create(baseUri + "products");
    }

    public URI productUrl(Product product) {
        return URI.create(baseUri + "products/" + product.getId());
    }

    public URI orderUrl(User user) {
        return URI.create(baseUri + "users/" + user.getId() + "/orders");
    }
}
