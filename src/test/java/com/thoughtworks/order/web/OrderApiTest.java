package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.infrastructure.repositories.UserRepository;
import com.thoughtworks.order.support.ApiSupport;
import com.thoughtworks.order.support.ApiTestRunner;

import static com.thoughtworks.order.support.TestHelper.*;
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

    private User user;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        user = prepareUser(userRepository);
    }

    @Test
    public void should_create_order_successful() {
        Response response = target("users/" + user.getId() + "/orders")
                .request()
                .post(Entity.json(orderJsonForTest()));

        assertThat(response.getStatus(), is(201));

    }
}
