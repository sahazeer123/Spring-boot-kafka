package com.kafka.kafkaproducer.Repository;

import com.kafka.kafkaproducer.Model.Event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends CrudRepository<Event,Long> {
    
}
