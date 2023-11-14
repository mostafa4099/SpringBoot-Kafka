package com.mostafa.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 11/7/2023 5:23 PM
 */
@Configuration
public class StringProducerConfig {
    @Value("${topic.string.flat.message.name}")
    private String flatMessageTopic;

    @Bean
    public NewTopic createStringFlatMessageTopic(){
        return new NewTopic(flatMessageTopic, 3, (short) 1);
    }
}
