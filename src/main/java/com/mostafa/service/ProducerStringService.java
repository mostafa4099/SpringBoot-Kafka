package com.mostafa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerStringService {
    private Logger logger = LoggerFactory.getLogger(ProducerStringService.class);

//    @Value("${spring.kafka.topic.name}")
//    private String topicName;
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Publish endpoint provided string message in kafka cluster within specified topic
     * @param message
     */
//    public void sendMessage(String message){
//        logger.info("Message sent: "+message);
//        kafkaTemplate.send(topicName, message);
//    }

}
