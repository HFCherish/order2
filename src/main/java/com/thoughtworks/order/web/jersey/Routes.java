package com.thoughtworks.order.web.jersey;

import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.domain.user.User;

import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.HashMap;

public class Routes {

    private final String baseUri;

    public Routes(UriInfo uriInfo) {
        baseUri = uriInfo.getBaseUri().toASCIIString();
    }

    public URI userUrl(User user) {
        return URI.create(String.format("%susers/%s", baseUri, user.getUserId().id()));
    }

    public URI productUrl() {
        return URI.create(baseUri + "products");
    }

    public URI productUrl(Product product) {
        return URI.create(baseUri + "products/" + product.getId());
    }
}
