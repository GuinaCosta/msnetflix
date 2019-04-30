package com.edu.fiap.catalogprocessing.repository;

import com.edu.fiap.catalogprocessing.model.entity.GenreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Genre Repository
 * @author agnaldo.almeida
 */
@Service
public interface GenreRepository extends CrudRepository<GenreEntity, Integer> {

    /**
     * finds genre by its name
     * @param genreName genre name to be found
     * @return genre entity found
     */
    GenreEntity findByGenreIgnoreCase(String genreName);
}
