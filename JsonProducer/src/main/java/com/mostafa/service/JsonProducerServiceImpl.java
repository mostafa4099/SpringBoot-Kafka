package com.mostafa.service;

import com.mostafa.dto.User;
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
public class JsonProducerServiceImpl implements JsonProducerService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${topic.json.data.name}")
    private String topic;

    @Override
    public void publishUserData(User user) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, user);

        future.whenComplete((result, ex) -> {
            if (null == ex) {
                System.out.println("Send User=" + user.toString()
                        + ". Offset=" + result.getRecordMetadata().offset()
                        + ". Partition= " + result.getRecordMetadata().partition() + ".");
            } else {
                System.out.println("Unable to send user '" + user.toString()
                        + "' due to '" + ex.getMessage() + "'.");
            }
        });
    }
}
