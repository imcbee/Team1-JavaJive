package com.bah.mcc.day1.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.mcc.day1.domain.Event;

public interface EventsRepository extends CrudRepository<Event, Long> {

}
