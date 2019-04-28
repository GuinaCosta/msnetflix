package com.edu.fiap.catalogservice.config;

import com.edu.fiap.catalogservice.model.request.CatalogRequest;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Kafka producer configuration class
 * @author agnaldo.almeida
 **/
@Configuration
@EnableKafka
public class KafkaProducerConfig {

    /**
     * bootstrap address of kafka
     **/
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    /**
     * factory of kafka producer
     *
     * @return DefaultKafkaProducerFactory for the project
     */
    @Bean
    @ConditionalOnMissingBean(ProducerFactory.class)
    @SuppressWarnings("Duplicates")
    public ProducerFactory<String, CatalogRequest> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    /**
     * Creates the bean of Kafka template
     * @return KafkaTemplate of CatalogRequest
     */
    @Bean
    public KafkaTemplate<String, CatalogRequest> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
