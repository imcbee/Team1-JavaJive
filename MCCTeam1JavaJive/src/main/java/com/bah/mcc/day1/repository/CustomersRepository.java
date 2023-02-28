package com.bah.mcc.day1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bah.mcc.day1.domain.Customer;

public interface CustomersRepository extends MongoRepository<Customer, Long> {

}