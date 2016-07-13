package com.thoughtworks.order.infrastructure.repositories;

import com.thoughtworks.order.domain.Product;

public interface ProductRepository {
    void save(Product product);
}
