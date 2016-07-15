package com.thoughtworks.order.infrastructure.repositories.impl;

import com.thoughtworks.order.domain.Payment;
import com.thoughtworks.order.infrastructure.mybatis.mappers.PaymentMapper;
import com.thoughtworks.order.infrastructure.repositories.PaymentRepository;

import javax.inject.Inject;
import java.util.Optional;

public class PaymentRepositoryImpl implements PaymentRepository {

    @Inject
    PaymentMapper paymentMapper;

    @Override
    public void save(Payment payment) {
        paymentMapper.save(payment);
    }

    @Override
    public Optional<Payment> findByOrder(String orderId) {
        return Optional.ofNullable(paymentMapper.findByOrder(orderId));
    }
}
