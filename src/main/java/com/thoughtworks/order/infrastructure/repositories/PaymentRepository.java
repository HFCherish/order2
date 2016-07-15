package com.thoughtworks.order.infrastructure.repositories;

import com.thoughtworks.order.domain.Payment;

import java.util.Optional;

public interface PaymentRepository {
    void save(Payment payment);

    Optional<Payment> findByOrder(String orderId);
}
