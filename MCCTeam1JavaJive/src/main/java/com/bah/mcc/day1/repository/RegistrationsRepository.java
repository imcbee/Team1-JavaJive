package com.bah.mcc.day1.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.mcc.day1.domain.Registration;

public interface RegistrationsRepository extends CrudRepository<Registration, Long>{

}
