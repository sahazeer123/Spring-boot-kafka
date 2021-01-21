package com.example.kafkaconsumer.Listener;

import com.example.kafkaconsumer.Model.Event;
import com.example.kafkaconsumer.Repository.MessageRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class KafkaConsumer {
    
    @Autowired
    private MessageRepo messageRepo;
    
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example2";

    @KafkaListener(topics = "Kafka_Example1", groupId = "group_id")
    public void consume(String message) {
        
        Event top = new Event(message);
        messageRepo.save(top);
        kafkaTemplate.send(TOPIC,"Hi this is from service2 ");
    } 
}
