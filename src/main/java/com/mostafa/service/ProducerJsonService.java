package com.mostafa.service;

import com.mostafa.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProducerJsonService {
    private Logger logger = LoggerFactory.getLogger(ProducerJsonService.class);

    @Value("${spring.kafka.topic-json.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    /**
     * Publish endpoint provided user data with json format in kafka cluster within specified topic
     * @param user
     */
    public void sendMessage(User user){
        logger.info("Message: "+user.toString());
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();
        kafkaTemplate.send(message);
    }

}
