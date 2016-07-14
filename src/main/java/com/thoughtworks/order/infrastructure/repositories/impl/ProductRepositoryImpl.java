package com.thoughtworks.order.infrastructure.repositories.impl;

import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;

import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public void save(Product product) {

    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(new Product());
    }
}
