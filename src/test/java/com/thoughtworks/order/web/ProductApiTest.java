package com.thoughtworks.order.web;

import com.thoughtworks.order.support.ApiSupport;
import com.thoughtworks.order.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class ProductApiTest extends ApiSupport {

    @Test
    public void should_create_product() {
        Map<String, Object> prodInfo = new HashMap(){{
            put("name", "Imran");
            put("description", "teacher");
            put("price", 1.1);
        }};
        Response response = target("/products").request().post(Entity.json(prodInfo));

        assertThat(response.getStatus(), is(201));

    }

}
