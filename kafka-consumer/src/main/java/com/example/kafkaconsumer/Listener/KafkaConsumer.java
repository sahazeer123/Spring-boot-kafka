package com.example.kafkaconsumer.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class KafkaConsumer {
    
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example2";

    @KafkaListener(topics = "Kafka_Example1", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message : " + message);
        kafkaTemplate.send(TOPIC,"Hi this is from service2 ");
    } 
}
