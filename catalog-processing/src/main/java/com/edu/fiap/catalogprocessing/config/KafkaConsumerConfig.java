package com.edu.fiap.catalogprocessing.config;

import com.edu.fiap.catalogprocessing.model.request.CatalogProcessingRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    /**
     * Kafka bootstrap address
     */
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    /**
     * Kafka consumer group.id
     */
    @Value(value = "${spring.kafka.consumer.group-id}")
    private String consumerGroupId;

    /**
     * Kafka Consumer Factory Bean
     * @return Consumer Factory
     */
    @Bean
    public ConsumerFactory<String, CatalogProcessingRequest> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props,
                new StringDeserializer(),
                new JsonDeserializer<>(CatalogProcessingRequest.class));
    }

    /**
     * Concurrent Kafka Listener Container Factory Bean
     * @return Kafka Listener Container Factory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CatalogProcessingRequest> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CatalogProcessingRequest> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}
