package com.thoughtworks.order.support;

import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;

import java.util.HashMap;
import java.util.Map;

public class TestHelper {
    public static final String NOT_EXIST_ID = "123";
    private static int auto_increment_key = 1;
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
}
