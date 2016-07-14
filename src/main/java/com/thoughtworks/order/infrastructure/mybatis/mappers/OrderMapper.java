package com.thoughtworks.order.infrastructure.mybatis.mappers;

import com.thoughtworks.order.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    void save(@Param("order") Order order);

    Order findById(@Param("id") String id);
}
