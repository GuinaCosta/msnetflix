package com.edu.fiap.watchlistservice.repository;

import com.edu.fiap.watchlistservice.model.entity.CatalogEntity;
import com.edu.fiap.watchlistservice.model.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * category service repository for category
 *
 * @author agnaldo.almeida
 *
 * @see CrudRepository
 * @see CrudRepository
 * */
@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
}
