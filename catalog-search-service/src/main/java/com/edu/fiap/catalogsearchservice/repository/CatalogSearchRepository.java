package com.edu.fiap.catalogsearchservice.repository;

/**
 * Interface para contrato de busca de catálog
 * */
public interface CatalogSearchRepository {

    /**
     * Busca o catálogo por gênero no banco de dados
     *
     * @param genre gênero para efetuar a busca
     *
     * @return retorna lista de catálogo obtida no banco
     **/
    public Object getByGenre(String genre);
}
