package com.thoughtworks.order.support;

import com.thoughtworks.order.domain.*;
import com.thoughtworks.order.infrastructure.repositories.OrderRepository;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;
import com.thoughtworks.order.infrastructure.repositories.UserRepository;

import java.util.*;

public class TestHelper {
    public static final String NOT_EXIST_ID = "123";
    public static final int ORDER_ITEM_QUANTITY = 2;
    private static int auto_increment_key = 1;
    public static final String INVALID_USER_NAME = "JKDL.JKL";
    public static final String VALID_USER_NAME = "Petrina";

    public static Map<String, Object> deployment(String appName, String releaseId) {
        return new HashMap<String, Object>() {{
            put("app", String.format("http://service-api.tw.com/apps/%s", appName));
            put("release", String.format("http://service-api.tw.com/apps/%s/releases/%s", appName, releaseId));
        }};
    }

    public static Map<String, Object> stackMap(String id, String name) {
        Map<String, Object> stackMap = new HashMap<String, Object>() {{
            put("id", id);
            put("name", name);
        }};
        return stackMap;
    }

    public static Map<String, Object> userMap(String email, String name) {
        return new HashMap<String, Object>() {{
            put("name", name);
            put("email", email);
        }};
    }


    public static Product productForTest() {
        return new Product("Imran", "teacher", 1.1);
    }

    public static Product prepareProduct(ProductRepository productRepository) {
        Product product = productForTest();
        productRepository.save(product);
        return product;
    }

    public static Map<String, Object> userJsonForTest(String name) {
        return new HashMap<String, Object>() {{
            put("name", name);
        }};
    }

    public static User userForTest(String name) {
        return new User(name);
    }

    public static User prepareUser(UserRepository userRepository) {
        User user = userForTest(VALID_USER_NAME);
        userRepository.save(user);
        return user;
    }

    public static Map<String, Object> orderJsonForTest(String productId) {
        return new HashMap<String, Object>() {{
            put("name", "Mary");
            put("address", "beijing");
            put("phone", "708906798");
            put("order_items", Arrays.asList(new HashMap<String, Object>() {{
                put("product_id", productId);
                put("quantity", ORDER_ITEM_QUANTITY);
            }}));
        }};
    }

    public static Map<String, Object> orderJstonWithNoOrderItemsForTes() {
        return new HashMap<String, Object>() {{
            put("name", "Mary");
            put("address", "beijing");
            put("phone", "708906798");
            put("order_items", Arrays.asList(new HashMap<String, Object>()));
        }};
    }

    public static Order orderForTest(User user, Product product) {
        return new Order("Mary",
                "beijing",
                "7057867",
                user.getId(),
                Arrays.asList(new OrderItem(product.getId(), 2, product.getPrice())));
    }

    public static Order prepareOrder(User user, Product product, OrderRepository orderRepository) {
        Order order = orderForTest(user, product);
        orderRepository.save(order);
        return order;
    }

    public static Map<String, Object> paymentJsonForTest() {
        return new HashMap<String, Object>() {{
            put("pay_type", "CASH");
            put("amount", 100);
        }};
    }

    public static Payment paymentForTest(Order order) {
        return new Payment(PayType.CASH, 100);
    }

}
