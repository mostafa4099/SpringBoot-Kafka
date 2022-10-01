package com.mostafa.service;

import com.mostafa.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    /**
     * Consume specified group's and topic's string data
     * @param user
     */
//    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
//    public void consumeString(String message){
//        logger.info("Consumed message: "+message);
//    }

    /**
     * Consume specified group's and topic's json data and auto deserialize in user object
     * @param user
     */
    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeJson(User user){
        logger.info("Consumed message: "+user);
    }
}
