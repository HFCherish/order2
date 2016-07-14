package com.thoughtworks.order.infrastructure.mybatis.mappers;

import com.thoughtworks.order.domain.OrderItem;
import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {
    void save(@Param("orderItem") OrderItem orderItem, @Param("orderId") String orderId);
}
