package com.mostafa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @Author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 11/7/2023 4:58 PM
 */
@Service
public class StringProducerServiceImpl implements StringProducerService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${topic.string.flat.message.name}")
    private String topic;

    @Override
    public void publishFlatMessageWithinTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, message);

        future.whenComplete((result, ex) -> {
            if (null == ex) {
                System.out.println("Send Message=" + message
                        + ". Offset=" + result.getRecordMetadata().offset()
                        + ". Partition= " + result.getRecordMetadata().partition() + ".");
            } else {
                System.out.println("Unable to send message '" + message
                        + "' due to '" + ex.getMessage() + "'.");
            }
        });
    }
}
