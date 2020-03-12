package com.grapeup.pekarsky.customerservice.jpa;

import com.grapeup.pekarsky.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
}
