package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;
import com.thoughtworks.order.support.ApiSupport;
import com.thoughtworks.order.support.ApiTestRunner;
import com.thoughtworks.order.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class ProductApiTest extends ApiSupport {

    @Inject
    ProductRepository productRepository;
    private Product product;

    @Test
    public void should_create_product() {
        Map<String, Object> prodInfo = new HashMap() {{
            put("name", "Imran");
            put("description", "teacher");
            put("price", 1.1);
        }};
        Response response = target("/products").request().post(Entity.json(prodInfo));

        assertThat(response.getStatus(), is(201));
        assertThat(response.getLocation().toString(), containsString("/products"));
    }

    @Test
    public void should_get_all_products_successful() {
        product = TestHelper.prepareProduct(productRepository);

        Response response = target("/products").request().get();

        assertThat(response.getStatus(), is(200));
        List items = response.readEntity(List.class);
        assertThat(items.size(), is(1));
        Map productInfo = (Map) items.get(0);
        verify_same_product_info_in_response(productInfo, product);
    }

    private void verify_same_product_info_in_response(Map productInfo, Product product) {
        assertThat(productInfo.get("uri").toString(), containsString("/products/" + this.product.getId()));
        assertThat(productInfo.get("id"), is(this.product.getId()));
        assertThat(productInfo.get("name"), is(this.product.getName()));
        assertThat(productInfo.get("description"), is(this.product.getDescription()));
        assertThat((double) productInfo.get("price"), is(closeTo(this.product.getPrice(), 0.1)));
    }

    @Test
    public void should_return_nothing_when_get_all_products_given_empty_databases() {
        Response response = target("/products").request().get();

        assertThat(response.getStatus(), is(200));
        List items = response.readEntity(List.class);
        assertThat(items.size(), is(0));
    }

    @Test
    public void should_get_one_product_successful() {
        product = TestHelper.prepareProduct(productRepository);

        Response response = target("/products/" + product.getId()).request().get();

        assertThat(response.getStatus(), is(200));
        verify_same_product_info_in_response(response.readEntity(Map.class), product);
    }

    @Test
    public void should_return_404_when_get_one_product_given_wrong_id() {
        Response response = target("/products/" + TestHelper.NOT_EXIST_ID).request().get();

        assertThat(response.getStatus(), is(404));

    }
}
