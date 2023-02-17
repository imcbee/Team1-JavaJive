package com.bah.mcc.day1.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.mcc.day1.domain.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

}