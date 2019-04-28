package com.edu.fiap.catalogservice.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * Kafka topic configuration Bean
 * @author agnaldo.almeida
 */
@Configuration
public class KafkaTopicConfig {

    /**
     * Kafka bootstrap address
     */
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    /**
     * Kafka admin configuration bean
     * @return Kafka admin configured
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    /**
     * New topic configuration bean
     * @return new topic
     */
    @Bean
    public NewTopic topic1() {
        return new NewTopic(GlobalConstants.CATALOG_TOPIC_NAME, 1, (short) 1);
    }
}
