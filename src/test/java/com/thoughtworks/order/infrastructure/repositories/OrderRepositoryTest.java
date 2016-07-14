package com.thoughtworks.order.infrastructure.repositories;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.support.ApiTestRunner;
import com.thoughtworks.order.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class OrderRepositoryTest {
    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    OrderRepository orderRepository;

    @Test
    public void should_save_and_get_order() {
        Order order = TestHelper.OrderForTest(userRepository, productRepository);

        orderRepository.save(order);
        Optional<Order> fetched = orderRepository.findById(order.getId());

        assertThat(fetched.isPresent(), is(true));
        Order fetchedOrder = fetched.get();
        assertThat(fetchedOrder.getId(), is(order.getId()));
        assertThat(fetchedOrder.getName(), is(order.getName()));
        assertThat(fetchedOrder.getAddress(), is(order.getAddress()));
        assertThat(fetchedOrder.getPhone(), is(order.getPhone()));
        assertThat(fetchedOrder.getUserId(), is(order.getUserId()));

        assertThat(fetchedOrder.getOrderItems().size(), is(1));
    }
}
