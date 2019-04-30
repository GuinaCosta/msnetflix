package com.edu.fiap.catalogprocessing.repository;

import com.edu.fiap.catalogprocessing.model.entity.CatalogGenreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Genre Repository
 * @author agnaldo.almeida
 */
@Service
public interface CatalogGenreRepository extends CrudRepository<CatalogGenreEntity, Integer> {

    /**
     * finds catalog by its genre name
     * @param genreName genre name to be found
     * @return catalogs genre entity found
     */
    CatalogGenreEntity findByGenreIgnoreCase(String genreName);

    /**
     * finds by catalogs by catalog id
     * @param catalogId catalog id
     * @return catalog genre by its id
     */
    CatalogGenreEntity findByCatalogId(Integer catalogId);
}
