package com.edu.fiap.watchlistservice.repository;

import com.edu.fiap.watchlistservice.model.entity.CatalogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Catalog service repository to create catalog item on database
 *
 * @author agnaldo.almeida
 *
 * @see CrudRepository
 * @see CrudRepository
 * */
@Repository
public interface CatalogServiceRepository extends CrudRepository<CatalogEntity, Integer> {

    /**
     * finds catalog item by its name
     **/
    List<CatalogEntity> findByNameIgnoreCaseContaining(String name);

}
