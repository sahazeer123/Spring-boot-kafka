package com.kafka.kafkaproducer.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class KafkaSer1Lis {

    @Autowired
    KafkaTemplate<String,String>kafkaTemplate;

    private Boolean toStop = false;

    public Boolean getToSTop() {
        return toStop;
    }

    public void setToStop(Boolean value) {
        this.toStop = value;
    }

    public void sendMsg() {
        kafkaTemplate.send("Kafka_Example1","This is from Service1 ");
    }


    @KafkaListener(topics = "Kafka_Example2", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message : " + message);
        if(!toStop)
           sendMsg();
        else
           this.toStop = false;
    } 
}
