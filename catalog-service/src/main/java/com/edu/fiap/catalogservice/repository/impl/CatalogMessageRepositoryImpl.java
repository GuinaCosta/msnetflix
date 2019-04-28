package com.edu.fiap.catalogservice.repository.impl;

import com.edu.fiap.catalogservice.model.request.CatalogRequest;
import com.edu.fiap.catalogservice.repository.CatalogMessageRepository;
import com.edu.fiap.catalogservice.repository.RepositoryConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @see com.edu.fiap.catalogservice.repository.CatalogMessageRepository
 */
@Service
@Slf4j
public class CatalogMessageRepositoryImpl implements CatalogMessageRepository {

    /**
     * Kafka template for sending the message
     */
    @Autowired
    private KafkaTemplate<String, CatalogRequest> kafkaTemplate;

    /**
     * @see CatalogMessageRepository#createCatalogMessage(CatalogRequest)
     * @param catalogRequest catalog item data for message
     * @return
     */
    @Override
    public boolean createCatalogMessage(CatalogRequest catalogRequest) {
        try {
            kafkaTemplate.send(RepositoryConstants.CATALOG_TOPIC_NAME, catalogRequest);
            return true;
        }
        catch (KafkaException ex) {
            log.error("Erro ao postar mensagem: {}", ex);
            return false;
        }
    }
}

