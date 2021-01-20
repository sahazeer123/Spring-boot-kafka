package com.kafka.kafkaproducer.Controller;

import com.kafka.kafkaproducer.Listener.KafkaSer1Lis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserController {

    @Autowired
    KafkaSer1Lis kafkaService;

    @GetMapping("/start")
    public String start() {

        kafkaService.sendMsg();

        return "published Successfully";
    }

    @GetMapping("/stop")
    public String stop(){

        kafkaService.setToStop(true);

        return "Stopped Successfully";
    }
}
