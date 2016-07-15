package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.infrastructure.repositories.OrderRepository;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;
import com.thoughtworks.order.infrastructure.repositories.UserRepository;
import com.thoughtworks.order.support.ApiSupport;
import com.thoughtworks.order.support.ApiTestRunner;
import static com.thoughtworks.order.support.TestHelper.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

@RunWith(ApiTestRunner.class)
public class PaymentApiTest extends ApiSupport {
    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    OrderRepository orderRepository;

    @Test
    public void should_pay_successfully() {
        Order order = prepareOrder(
                prepareUser(userRepository),
                prepareProduct(productRepository),
                orderRepository);

        String paymentUri = "users/" + order.getUserId() + "/orders/" + order.getId() +"/payment";
        Response response = target(paymentUri).request().post(Entity.json(paymentJsonForTest()));

        assertThat(response.getStatus(), is(201));

    }
}
