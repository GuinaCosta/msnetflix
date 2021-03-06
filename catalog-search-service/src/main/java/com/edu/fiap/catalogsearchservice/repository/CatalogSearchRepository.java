package com.edu.fiap.catalogsearchservice.repository;

import com.edu.fiap.catalogsearchservice.model.entity.CatalogEntity;

/**
 * Interface para contrato de busca de catálogo
 *
 * @author agnaldo.almeida
 * */
public interface CatalogSearchRepository {

    /**
     * Busca o catálogo por gênero no banco de dados
     *
     * @param genre gênero para efetuar a busca
     *
     * @return retorna lista de catálogo obtida no banco
     **/
    CatalogEntity getByGenre(String genre);
}
