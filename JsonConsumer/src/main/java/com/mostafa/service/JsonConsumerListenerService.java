package com.mostafa.service;

import com.mostafa.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @Author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 11/9/2023 11:03 AM
 */
@Service
public class JsonConsumerListenerService {
    Logger logger = LoggerFactory.getLogger(JsonConsumerListenerService.class);

    @KafkaListener(topics = "${topic.json.data.name}",
            groupId = "${consumer.group-id}")
    public void consume(User user) {
        logger.info("Consumer consume user = '" + user.toString() + "'");
    }
}
