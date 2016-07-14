package com.thoughtworks.order.infrastructure.repositories;

import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.support.ApiTestRunner;
import com.thoughtworks.order.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

@RunWith(ApiTestRunner.class)
public class ProductRepositoryTest {
    @Inject
    ProductRepository productRepository;

    @Test
    public void should_save_product() {
        Product product = TestHelper.productForTest();

        productRepository.save(product);
        Optional<Product> fetched = productRepository.findById(product.getId());

        assertThat(fetched.isPresent(), is(true));
        Product fetchedProduct = fetched.get();
        assertThat(fetchedProduct.getId(), is(product.getId()));
        assertThat(fetchedProduct.getName(), is(product.getName()));
        assertThat(fetchedProduct.getDescription(), is(product.getDescription()));
        assertThat(fetchedProduct.getPrice(), is(closeTo(product.getPrice(),0.1)));

    }

}
