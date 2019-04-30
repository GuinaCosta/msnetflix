package com.edu.fiap.catalogprocessing.repository;

import com.edu.fiap.catalogprocessing.model.entity.CatalogGenreEntity;
import com.edu.fiap.catalogprocessing.model.entity.CatalogKeywordsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Genre Repository
 * @author agnaldo.almeida
 */
@Service
public interface CatalogKeywordRepository extends CrudRepository<CatalogKeywordsEntity, Integer> {

    /**
     * finds catalog by its genre name
     * @param keyword genre name to be found
     * @return catalogs genre entity found
     */
    CatalogKeywordsEntity findByKeywordIgnoreCase(String keyword);

    /**
     * finds by catalogs by catalog id
     * @param catalogId catalog id
     * @return catalog genre by its id
     */
    CatalogKeywordsEntity findByCatalogId(Integer catalogId);
}
