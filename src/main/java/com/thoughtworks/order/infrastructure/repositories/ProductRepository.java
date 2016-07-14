package com.thoughtworks.order.infrastructure.repositories;

import com.thoughtworks.order.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void save(Product product);

    Optional<Product> findById(String id);

    Optional<List<Product>> findAll();
}
