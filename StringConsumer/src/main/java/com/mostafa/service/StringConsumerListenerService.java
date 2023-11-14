package com.mostafa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @Author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 11/9/2023 11:03 AM
 */
@Service
public class StringConsumerListenerService {
    Logger logger = LoggerFactory.getLogger(StringConsumerListenerService.class);

    @KafkaListener(topics = "${topic.string.flat.message.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        logger.info("Consumer consume message = '" + message + "'");
    }
}
