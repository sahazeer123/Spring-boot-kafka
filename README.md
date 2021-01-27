# Spring-boot-kafka
Two spring boot microservices that pulishes and recieves messages using kafka as a messaging serivce and store messsage using postresDB

## Technologies
Spring-boot
Kafka
Postgres Database

## Setup
To run this project, install postgres locally 
create database name eventdb
Run postrges in port number 5432(default port)

Zookeeper and kafka should be running on their default port before running spring boot microservice

Run microservice kafka-producer and kafka-consumer using gradle
./gradlew bootRun
  *'kafka-producer' runs on port number 8080
  *'kafka-consumer' runs on prot number 8081

### To start the ping pong,send api request to kafka-producer
  ##### localhost:8080/kafka/start

### To stop the ping pong
  ##### localhost:8080/kafka/stop

All message for kafka-producer will be stored in table Db1


All message for kafka-consumer will be stored in table Db2
