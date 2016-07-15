package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.Order;
import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.infrastructure.repositories.OrderRepository;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;
import com.thoughtworks.order.infrastructure.repositories.UserRepository;
import com.thoughtworks.order.support.ApiSupport;
import com.thoughtworks.order.support.ApiTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

import static com.thoughtworks.order.support.TestHelper.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

@RunWith(ApiTestRunner.class)
public class OrderApiTest extends ApiSupport {

    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    OrderRepository orderRepository;

    private User user;
    private Product product;
    private String ordersUri;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        user = prepareUser(userRepository);
        product = prepareProduct(productRepository);
        ordersUri = "users/" + user.getId() + "/orders";
    }

    @Test
    public void should_create_order_successful() {
        Response response = target(ordersUri)
                .request()
                .post(Entity.json(orderJsonForTest(product.getId())));

        assertThat(response.getStatus(), is(201));
        assertThat(response.getLocation().toString(), containsString(ordersUri));
    }

    @Test
    public void should_400_when_create_order_given_zero_order_items() {
        Response response = target(ordersUri)
                .request()
                .post(Entity.json(orderJstonWithNoOrderItemsForTes()));

        assertThat(response.getStatus(), is(400));
    }

    @Test
    public void should_400_when_create_order_given_invalid_product_id() {
        Response response = target(ordersUri)
                .request()
                .post(Entity.json(orderJsonForTest(NOT_EXIST_ID)));

        assertThat(response.getStatus(), is(400));
    }

    @Test
    public void should_get_one_order_successfully() {
        //given
        Order order = prepareOrder(user, product, orderRepository);
        String getUri = ordersUri + "/" + order.getId();

        //when
        Response response = target(getUri).request().get();

        //then
        assertThat(response.getStatus(), is(200));

        Map orderInfo = response.readEntity(Map.class);
        verifyBasicOrderInfoInResponse(order, getUri, orderInfo);
        verifyOrderItemsInfoInResponseBody(orderInfo);
    }

    public void verifyOrderItemsInfoInResponseBody(Map orderInfo) {
        List orderItems = (List)orderInfo.get("order_items");
        assertThat(orderItems.size(), is(1));
        Map orderItem = (Map)orderItems.get(0);
        assertThat(orderItem.get("product_id").toString(), is(product.getId()));
        assertThat((int)orderItem.get("quantity"), is(ORDER_ITEM_QUANTITY));
        assertThat((double)orderItem.get("amount"), is(closeTo(product.getPrice(), 0.1)));
    }

    public void verifyBasicOrderInfoInResponse(Order order, String getUri, Map orderInfo) {
        assertThat(orderInfo.get("uri").toString(), containsString(getUri));
        assertThat(orderInfo.get("name").toString(), is(order.getName()));
        assertThat(orderInfo.get("address").toString(), is(order.getAddress()));
        assertThat(orderInfo.get("phone").toString(), is(order.getPhone()));
        assertThat((double)orderInfo.get("total_price"), is(order.getTotalPrice()));
        assertThat(orderInfo.get("created_at"), is(notNullValue()));
    }

    @Test
    public void should_404_when_get_some_order_given_invalid_id() {
        //given
        Order order = prepareOrder(user, product, orderRepository);
        String getUri = ordersUri + "/" + NOT_EXIST_ID;

        //when
        Response response = target(getUri).request().get();

        //then
        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_get_all_orders_successfully() {
        //given
        Order order = prepareOrder(user, product, orderRepository);

        //when
        Response response = target(ordersUri).request().get();

        //then
        assertThat(response.getStatus(), is(200));

        List orders = response.readEntity(List.class);
        assertThat(orders.size(), is(1));
        Map orderInfo = (Map)orders.get(0);
        verifyBasicOrderInfoInResponse(order, ordersUri + "/" + order.getId(), orderInfo);
    }

    @Test
    public void should_return_empty_when_get_all_orders_given_empty_database() {
        //when
        Response response = target(ordersUri).request().get();

        //then
        assertThat(response.getStatus(), is(200));

        List orders = response.readEntity(List.class);
        assertThat(orders.size(), is(0));
    }
}
