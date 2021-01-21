package com.kafka.kafkaproducer.Listener;

import com.kafka.kafkaproducer.Model.Event;
import com.kafka.kafkaproducer.Repository.MessageRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class KafkaSer1Lis {

    @Autowired
    private MessageRepo messageRepo;
    
    @Autowired
    private KafkaTemplate<String,String>kafkaTemplate;

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
        Event top = new Event(message);
        this.messageRepo.save(top);
        if(!toStop)
           sendMsg();
        else
           this.toStop = false;
    } 
}
