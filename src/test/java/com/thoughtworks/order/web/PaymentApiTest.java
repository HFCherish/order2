package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.domain.Payment;
import com.thoughtworks.order.infrastructure.repositories.OrderRepository;
import com.thoughtworks.order.infrastructure.repositories.PaymentRepository;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;
import com.thoughtworks.order.infrastructure.repositories.UserRepository;
import com.thoughtworks.order.support.ApiSupport;
import com.thoughtworks.order.support.ApiTestRunner;
import static com.thoughtworks.order.support.TestHelper.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.apache.ibatis.annotations.Param;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Map;

@RunWith(ApiTestRunner.class)
public class PaymentApiTest extends ApiSupport {
    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    OrderRepository orderRepository;

    @Inject
    PaymentRepository paymentRepository;

    private Order order;
    private String paymentUri;
    private String orderUri;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        order = prepareOrder(
                prepareUser(userRepository),
                prepareProduct(productRepository),
                orderRepository);
        orderUri = "users/" + order.getUserId() + "/orders/" + order.getId();
        paymentUri = orderUri + "/payment";
    }

    @Test
    public void should_pay_successfully() {
        Response response = target(paymentUri).request().post(Entity.json(paymentJsonForTest()));

        assertThat(response.getStatus(), is(201));
    }

    @Test
    public void should_get_payment_successfully() {
        Payment payment = preparePayment(order, paymentRepository);

        Response response = target(paymentUri).request().get();

        assertThat(response.getStatus(), is(200));

        Map paymentInfo = response.readEntity(Map.class);
        assertThat(paymentInfo.get("pay_type"), is(payment.getType()));
        assertThat((double)paymentInfo.get("amount"), is(payment.getAmount()));
        assertThat(paymentInfo.get("order_uri").toString(), containsString(orderUri));
        assertThat(paymentInfo.get("uri").toString(), containsString(paymentUri));
        assertThat(paymentInfo.get("created_at"), is(notNullValue()));
    }
}
