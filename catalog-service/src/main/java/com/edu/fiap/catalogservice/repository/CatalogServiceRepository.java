package com.edu.fiap.catalogservice.repository;

import com.edu.fiap.catalogservice.model.entity.CatalogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Catalog service repository to create catalog item on database
 *
 * @author agnaldo.almeida
 *
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.data.repository.CrudRepository
 * */
@Service
public interface CatalogServiceRepository extends CrudRepository<CatalogEntity, Integer> {

    /**
     * finds catalog item by its name
     **/
    List<CatalogEntity> findByNameIgnoreCaseContaining(String name);

}
