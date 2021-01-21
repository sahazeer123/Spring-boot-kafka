package com.example.kafkaconsumer.Repository;

import com.example.kafkaconsumer.Model.Event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends CrudRepository<Event,Long> {
    
}
