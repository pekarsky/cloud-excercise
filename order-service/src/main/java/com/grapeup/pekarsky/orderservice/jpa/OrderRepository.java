package com.grapeup.pekarsky.orderservice.jpa;

import com.grapeup.pekarsky.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
}
