package com.thoughtworks.order.infrastructure.mybatis.mappers;

import com.thoughtworks.order.domain.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {
    Payment findByOrder(@Param("orderId") String orderId);

    void save(@Param("payment") Payment payment);
}
