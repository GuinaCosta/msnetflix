package com.edu.fiap.catalogprocessing.event;

import com.edu.fiap.catalogprocessing.config.GlobalConstants;
import com.edu.fiap.catalogprocessing.facade.CatalogProcessingFacade;
import com.edu.fiap.catalogprocessing.model.request.CatalogProcessingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Catalog listener to process topic
 * @author agnaldo.almeida
 */
@Component
@Slf4j
public class CatalogProcessingListener {

    /**
     * Kafka consumer group.id
     */
    @Value(value = "${spring.kafka.consumer.group-id}")
    private String consumerGroupId;

    /**
     * processing facade
     */
    @Autowired
    private CatalogProcessingFacade processingFacade;

    /**
     * Process the creation of catalog item details
     * @param catalogProcessingRequest topic item got from kafka
     */
    @KafkaListener(topics = GlobalConstants.CATALOG_TOPIC_NAME,
                    containerFactory = "kafkaListenerContainerFactory")
    public void catalogListener(CatalogProcessingRequest catalogProcessingRequest){
        log.info("Catalog from kafka: {}", catalogProcessingRequest.toString());
        if (processingFacade.saveCatalogDetails(catalogProcessingRequest)) {
            log.info("Details saved");
        }
        else {
            log.warn("Details not saved");
        }
    }
}
