package com.mostafa.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 11/7/2023 5:23 PM
 */
@Configuration
public class JsonProducerConfig {
    @Value("${topic.json.data.name}")
    private String jsonDataTopic;

    @Bean
    public NewTopic createJsonDataTopic() {
        return TopicBuilder.name(jsonDataTopic)
                .partitions(3)
                .build();
    }

    //*****Java based configuration start*****

    /**
     * instead of application.properties based configuration we can use java based configuration also.
     * java based configuration is preferable when we need to configure custom things like ssl things
     * for straight forward things properties based configuration preferable instead of java based
     * to use java based configuration need to remove or comment application.properties kafka configuration.
     */
    @Bean
    public Map<String, Object> producerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return props;
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    //*****Java based configuration end*****
}
