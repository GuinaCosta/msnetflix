package com.edu.fiap.catalogservice.facade.impl;

import com.edu.fiap.catalogservice.facade.CatalogServiceFacade;
import com.edu.fiap.catalogservice.model.entity.CatalogEntity;
import com.edu.fiap.catalogservice.model.request.CatalogRequest;
import com.edu.fiap.catalogservice.model.response.CatalogResponse;
import com.edu.fiap.catalogservice.repository.CatalogMessageRepository;
import com.edu.fiap.catalogservice.repository.CatalogServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @see com.edu.fiap.catalogservice.facade.CatalogServiceFacade
 **/
@Service
@Slf4j
public class CatalogServiceFacadeImpl implements CatalogServiceFacade {

    /**
     * Catalog service CRUD repository
     */
    @Autowired
    private CatalogServiceRepository catalogServiceRepository;

    /**
     * Catalog messaging repository
     */
    @Autowired
    private CatalogMessageRepository catalogMessageRepository;

    /**
     * @see CatalogServiceFacade#saveCatalog(CatalogRequest)
     **/
    @Override
    public CatalogResponse saveCatalog(CatalogRequest catalogRequest) {
        CatalogEntity catalogEntity;

        catalogEntity = CatalogEntity.createFromCatalogRequest(catalogRequest);

        Integer id = catalogServiceRepository.save(catalogEntity).getCatalogId();

        if (id > 0) {
            catalogRequest.setCatalogId(id);
            if (catalogMessageRepository.createCatalogMessage(catalogRequest)) {
                log.info("Catalogo postado no kafka");
            }
            else {
                log.warn("Catalogo criado, mas não postado no kafka");
            }
        }

        return new CatalogResponse(id);
    }

    /**
     * @see CatalogServiceFacade#getCatalogs(String)
     **/
    @Override
    public List<CatalogResponse> getCatalogs(String name) {
        List<CatalogResponse> catalogResponseList;

        List<CatalogEntity> catalogEntityList = catalogServiceRepository.findByNameIgnoreCaseContaining(name);

        catalogResponseList = catalogEntityList.stream()
                .map(catalogEntity -> CatalogResponse.createFromCatalogEntity(catalogEntity))
                .collect(Collectors.toList());

        return catalogResponseList;
    }

    /**
     * @see CatalogServiceFacade#getCatalog(Integer)
     **/
    @Override
    public CatalogResponse getCatalog(Integer id) {
        CatalogResponse catalogResponse;

        Optional<CatalogEntity> catalogEntity = catalogServiceRepository.findById(id);

        if (catalogEntity.isPresent()) {
            catalogResponse = CatalogResponse.createFromCatalogEntity(catalogEntity.get());
        }
        else {
            catalogResponse = null;
        }

        return catalogResponse;
    }

    /**
     * @see CatalogServiceFacade#deleteCatalog(Integer)
     **/
    @Override
    public void deleteCatalog(Integer id) {
        catalogServiceRepository.deleteById(id);
    }
}
