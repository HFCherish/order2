package com.thoughtworks.order.infrastructure.repositories;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.domain.OrderItem;
import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.support.ApiTestRunner;
import com.thoughtworks.order.support.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static com.thoughtworks.order.support.TestHelper.ORDER_ITEM_QUANTITY;
import static com.thoughtworks.order.support.TestHelper.prepareProduct;
import static com.thoughtworks.order.support.TestHelper.prepareUser;
import static org.hamcrest.CoreMatchers.notNullValue;
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
    private Product product;
    private User user;

    @Before
    public void setUp() {
        user = prepareUser(userRepository);
        product = prepareProduct(productRepository);
    }

    @Test
    public void should_save_and_get_order() {
        Order order = TestHelper.orderForTest(user, product);

        orderRepository.save(order);
        Optional<Order> fetched = orderRepository.findById(order.getId());

        assertThat(fetched.isPresent(), is(true));
        Order fetchedOrder = fetched.get();
        verifyBaserOrderIsSame(order, fetchedOrder);

        assertThat(fetchedOrder.getOrderItems().size(), is(1));
        OrderItem orderItem = fetchedOrder.getOrderItems().get(0);
        assertThat(orderItem.getProductId(), is(product.getId()));
        assertThat(orderItem.getQuantity(), is(ORDER_ITEM_QUANTITY));
        assertThat(orderItem.getAmount(), is(product.getPrice()));
    }

    public void verifyBaserOrderIsSame(Order order, Order fetchedOrder) {
        assertThat(fetchedOrder.getId(), is(order.getId()));
        assertThat(fetchedOrder.getName(), is(order.getName()));
        assertThat(fetchedOrder.getAddress(), is(order.getAddress()));
        assertThat(fetchedOrder.getPhone(), is(order.getPhone()));
        assertThat(fetchedOrder.getUserId(), is(order.getUserId()));
        assertThat(fetchedOrder.getTotalPrice(), is(order.getTotalPrice()));
        assertThat(fetchedOrder.getCreatedAt(), is(notNullValue()));
    }

    @Test
    public void should_get_all_orders() {
        Order order = TestHelper.prepareOrder(user, product, orderRepository);

        List<Order> fetched = orderRepository.findAllOfUser(user.getId());

        assertThat(fetched.size(), is(1));
        Order fetchedOrder = fetched.get(0);
        verifyBaserOrderIsSame(order, fetchedOrder);

    }
}
