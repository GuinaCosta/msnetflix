package com.edu.fiap.catalogprocessing.facade.impl;

import com.edu.fiap.catalogprocessing.facade.CatalogProcessingFacade;
import com.edu.fiap.catalogprocessing.model.entity.CatalogGenreEntity;
import com.edu.fiap.catalogprocessing.model.entity.CatalogKeywordsEntity;
import com.edu.fiap.catalogprocessing.model.entity.GenreEntity;
import com.edu.fiap.catalogprocessing.model.request.CatalogProcessingRequest;
import com.edu.fiap.catalogprocessing.repository.CatalogGenreRepository;
import com.edu.fiap.catalogprocessing.repository.CatalogKeywordRepository;
import com.edu.fiap.catalogprocessing.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see com.edu.fiap.catalogprocessing.facade.CatalogProcessingFacade
 */
@Service
public class CatalogProcessingFacadeImpl implements CatalogProcessingFacade {

    /**
     * Genre repository
     */
    @Autowired
    private GenreRepository genreRepository;

    /**
     * Catalog Genre repository
     */
    @Autowired
    private CatalogGenreRepository catalogGenreRepository;

    /**
     * Catalog keywords repository
     */
    @Autowired
    private CatalogKeywordRepository catalogKeywordRepository;

    /**
     * @see CatalogProcessingFacade#saveCatalogDetails(CatalogProcessingRequest)
     */
    @Override
    public boolean saveCatalogDetails(CatalogProcessingRequest catalogRequest) {
        this.createGenreIfDoesNotExists(catalogRequest.getGenres());
        Integer totalGenresCreated = this.createCatalogGenres(catalogRequest.getGenres(),
                catalogRequest.getCatalogId());
        this.createKeyWords(catalogRequest);

        return totalGenresCreated > 0;
    }

    /**
     * Saves genres that does not exists
     * @param genreNameList
     */
    private void createGenreIfDoesNotExists(List<String> genreNameList) {
        for (int i = 0; i < genreNameList.size(); i++) {
            if (genreRepository.findByGenreIgnoreCase(genreNameList.get(i)) == null) {
                genreRepository.save(new GenreEntity(genreNameList.get(i)));
            }
        }
    }

    /**
     * creates catalog item genres
     * @param genreNameList
     */
    private Integer createCatalogGenres(List<String> genreNameList, Integer catalogId) {
        Integer totalCreated = 0;
        for (int i = 0; i < genreNameList.size(); i++) {
            if (catalogGenreRepository.save(new CatalogGenreEntity(genreNameList.get(i), catalogId))
                    .getCatalogGenreId() > 0) {
                totalCreated++;
            }
        }

        return totalCreated;
    }

    /**
     * creates the list of keywords
     * @param catalogRequest
     * @return
     */
    private Integer createKeyWords(CatalogProcessingRequest catalogRequest) {
        List<CatalogKeywordsEntity> keywordList = new ArrayList<>();

        keywordList.addAll(catalogRequest.getGenres()
                .stream()
                .map(s -> new CatalogKeywordsEntity(s, catalogRequest.getCatalogId()))
                .collect(Collectors.toList()));

        keywordList.addAll(catalogRequest.getKeyWords()
                .stream()
                .map(s -> new CatalogKeywordsEntity(s, catalogRequest.getCatalogId()))
                .collect(Collectors.toList()));

        keywordList.add(new CatalogKeywordsEntity(catalogRequest.getProducer(), catalogRequest.getCatalogId()));
        keywordList.add(new CatalogKeywordsEntity(catalogRequest.getDirector(), catalogRequest.getCatalogId()));

        if (catalogRequest.getCast().split(",").length > 0) {
            keywordList.addAll(Arrays.stream(catalogRequest.getCast().split(","))
                    .map(s -> new CatalogKeywordsEntity(s, catalogRequest.getCatalogId()))
                    .collect(Collectors.toList()));
        }
        catalogKeywordRepository.saveAll(keywordList);

        return 1;
    }
}
