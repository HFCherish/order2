package com.thoughtworks.order.infrastructure.repositories.impl;

import com.thoughtworks.order.domain.Product;
import com.thoughtworks.order.infrastructure.mybatis.mappers.ProductMapper;
import com.thoughtworks.order.infrastructure.repositories.ProductRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {
    @Inject
    ProductMapper productMapper;

    @Override
    public void save(Product product) {
        productMapper.save(product);
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(productMapper.findById(id));
    }

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }
}
