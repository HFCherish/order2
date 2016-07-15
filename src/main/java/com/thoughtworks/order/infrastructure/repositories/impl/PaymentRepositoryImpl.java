package com.thoughtworks.order.infrastructure.repositories.impl;

import com.thoughtworks.order.domain.Payment;
import com.thoughtworks.order.infrastructure.repositories.PaymentRepository;

import java.util.Optional;

public class PaymentRepositoryImpl implements PaymentRepository {
    @Override
    public void save(Payment payment) {

    }

    @Override
    public Optional<Payment> findByOrder(String orderId) {
        return Optional.ofNullable(new Payment());
    }
}
