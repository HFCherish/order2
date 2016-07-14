package com.thoughtworks.order.infrastructure.mybatis.mappers;

import com.thoughtworks.order.domain.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    void save(@Param("product") Product product);

    Product findById(@Param("prodId") String prodId);
}
