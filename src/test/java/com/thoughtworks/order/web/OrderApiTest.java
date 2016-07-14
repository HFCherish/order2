package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;
import com.thoughtworks.order.infrastructure.repositories.UserRepository;
import com.thoughtworks.order.support.ApiSupport;
import com.thoughtworks.order.support.ApiTestRunner;

import static com.thoughtworks.order.support.TestHelper.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

@RunWith(ApiTestRunner.class)
public class OrderApiTest extends ApiSupport {

    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    private User user;
    private Product product;
    private String createUri;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        user = prepareUser(userRepository);
        product = prepareProduct(productRepository);
        createUri = "users/" + user.getId() + "/orders";
    }

    @Test
    public void should_create_order_successful() {
        Response response = target(createUri)
                .request()
                .post(Entity.json(orderJsonForTest(product.getId())));

        assertThat(response.getStatus(), is(201));
        assertThat(response.getLocation().toString(), containsString(createUri));
    }

    @Test
    public void should_400_when_create_order_given_zero_order_items() {
        Response response = target(createUri)
                .request()
                .post(Entity.json(orderJstonWithNoOrderItemsForTes()));

        assertThat(response.getStatus(), is(400));
    }

    @Test
    public void should_400_when_create_order_given_invalid_product_id() {
        Response response = target(createUri)
                .request()
                .post(Entity.json(orderJsonForTest(NOT_EXIST_ID)));

        assertThat(response.getStatus(), is(400));
    }

    @Test
    public void should_get_one_order_successfully() {
        String getUri = createUri + "/" + product.getId();
        Response response = target(getUri).request().get();

        assertThat(response.getStatus(), is(200));

    }
}
